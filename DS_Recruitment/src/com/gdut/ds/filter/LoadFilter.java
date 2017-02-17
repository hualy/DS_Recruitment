package com.gdut.ds.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadFilter implements Filter {

	public void destroy() {
	

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		
		String requestUrlString = httpRequest.getServletPath();
		
//		System.out.println("filter:"+requestUrlString);
		
		if(null!=httpRequest.getSession().getAttribute("admin")){
			chain.doFilter(request, response);
		}else{
			if(requestUrlString.indexOf("LoginManager.jsp")==-1)
				((HttpServletResponse)response).sendRedirect("/DS/manPage/LoginManager.jsp");
			else chain.doFilter(request, response);

		} 
		
		//System.out.println("LoadFilter:"+requestUrlString);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

}
