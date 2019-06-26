package com.yu.msg;

import javax.servlet.http.HttpServletRequest;

public class BizMessage {
	MsgManager msg;
	HttpServletRequest request;
	
	public MsgManager getBusinessParameters() {
		msg.setRequest(request);
		return msg;		
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setBusinessParameters(MsgManager msg) {
		this.msg = msg;		
	}
}
