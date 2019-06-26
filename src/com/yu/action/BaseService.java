package com.yu.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import com.yu.dbc.DataConnection;
import com.yu.msg.BizMessage;
public class BaseService {
	
	public void invokeMethod(String classname,String methodname,BizMessage msg) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException{
		String url = "com.yu.service.";
		Class<?> clazz = Class.forName(url+classname);
		DataConnection link = new DataConnection();
		Method[] methods = clazz.getDeclaredMethods();  
		        for (Method method : methods) {  		             
		            boolean hasAnnotation = method.isAnnotationPresent(BSOMethod.class);  
		            if (hasAnnotation) {  		                 
		            	BSOMethod annotation = method.getAnnotation(BSOMethod.class);  
		                if(methodname.equals(annotation.Method())) {
			                method.invoke(clazz.newInstance(),msg,link);
		                }
		            }  
		        }  
		}

}
