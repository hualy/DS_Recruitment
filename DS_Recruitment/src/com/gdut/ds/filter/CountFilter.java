package com.gdut.ds.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CountFilter implements Filter{

	private FilterConfig filterConfig;
	
	
	public void destroy() {
		
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		
		ServletContext context = filterConfig.getServletContext();
		int count = (Integer) context.getAttribute("count");
		count++;
		context.setAttribute("count", count);					//记录访问该页面的数量
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.filterConfig = filterConfig;
		
	}

}
