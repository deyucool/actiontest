package com.yu.dbc;

import java.sql.*;

public class DataResultSet {
    public ResultSet QueryPreparedSql(DataConnection aLink, String aSql, String data){
        ResultSet rs = null;
        StringBuffer Sql = new StringBuffer();
        Sql.append(aSql);
        try {
            Connection conn = aLink.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(Sql.toString(),ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, data);
            if(conn != null){
                rs = pstmt.executeQuery();
            }
            aLink.CloseConnection(conn, null, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet QueryPreparedSql(DataConnection aLink, String aSql, String[] data){
        ResultSet rs = null;
        StringBuffer Sql = new StringBuffer();
        Sql.append(aSql);
        Sql.toString();
        try {
            Connection conn = aLink.getConnection();
            Statement statement = conn.createStatement();
            PreparedStatement pstmt=conn.prepareStatement(Sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, "1");
            if(conn != null){
                rs = pstmt.executeQuery();
            }
            aLink.CloseConnection(conn, null, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public Boolean UpdatePreparedSql(DataConnection aLink, String aSql, String[] data){
        try {
            Connection conn = aLink.getConnection();
            Statement statement = conn.createStatement();
            PreparedStatement pstmt=conn.prepareStatement(aSql,ResultSet.CONCUR_UPDATABLE);
            for(int i=0;i<data.length;i++){
                pstmt.setString(i+1, data[i]);
            }
            if(conn != null){
                pstmt.executeUpdate();
            }
            aLink.CloseConnection(conn, null, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }
}
