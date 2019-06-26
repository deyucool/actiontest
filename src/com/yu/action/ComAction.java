package com.yu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.msg.BizMessage;
import com.yu.msg.MsgManager;

public class ComAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
		BizMessage msg = new BizMessage();
		BaseService service = new BaseService();
		MsgManager msgm = new MsgManager();
		msg.setBusinessParameters(msgm);

		String clazz = request.getParameter("service");
		String method = request.getParameter("method");
		msg.setRequest(request);
		try {
			service.invokeMethod(clazz,method,msg);
			//response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.write(msgm.getMsg().toString());
		    out.close();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	  }

	  public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	  {
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      out.write("<h1>123</h1>");
	      out.close();
	  }
}
