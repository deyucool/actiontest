package com.yu.msg;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public class MsgManager {
	HttpServletRequest request;
	JSONObject json = new JSONObject();
	
	public String AsString(String k) {
		return request.getParameter(k);		
	}
	
	public void setString(String k,String v) {
		json.put(k,v);
	}
	
	public JSONObject getMsg() {
		return json;		
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
