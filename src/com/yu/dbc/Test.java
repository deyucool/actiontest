package com.yu.dbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) throws Exception {
        DataConnection conn = new DataConnection();
        DataResultSet re = new DataResultSet();
        ResultSet rs = re.QueryPreparedSql(conn,"select * from p_user where username = ? ","U00001");
        while(rs.next()){
            System.out.println(rs.getString("pwd"));
        }

    }
}
