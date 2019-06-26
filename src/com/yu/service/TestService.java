package com.yu.service;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yu.action.BSOMethod;
import com.yu.consts.ConstColumn;
import com.yu.dbc.DataConnection;
import com.yu.dbc.DataResultSet;
import com.yu.msg.BizMessage;
import com.yu.msg.MsgManager;

public class TestService {
	DataResultSet bizUtils = new DataResultSet();
	
	
	@BSOMethod(Method="getpwd")
	public  void doGetPwd(BizMessage Msg,DataConnection dbLink) {
		MsgManager MsgPut = Msg.getBusinessParameters();
		
		String userid = MsgPut.AsString("userid");
		String pwd = "";
		
		String sql = "select * from p_user where username = ? ";
		ResultSet rs = bizUtils.QueryPreparedSql(dbLink,sql,userid);
        try {
			while(rs.next()){
				pwd=rs.getString("pwd");
			}
			
			MsgPut.setString(ConstColumn.RET_CODE, ConstColumn.ONE);
	        MsgPut.setString(ConstColumn.JSON, pwd);
		} catch (SQLException e) {
			MsgPut.setString(ConstColumn.RET_CODE, ConstColumn.ZERO);
			e.printStackTrace();
		}
	}
}
