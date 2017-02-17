package com.gdut.ds.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	
	
	public void sessionCreated(HttpSessionEvent arg0) {			//根据session的创建来将浏览量加一，但是还是有个缺点就是管理员端
	
		ServletContext context = arg0.getSession().getServletContext();
		int count = (Integer) context.getAttribute("count");
		count++;
		context.setAttribute("count", count);					//记录访问该页面的数量

	}

	
	public void sessionDestroyed(HttpSessionEvent arg0) {


	}

}
