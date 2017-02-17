package com.gdut.ds.action.userInfo;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLogoutAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;

	
	@Override
	public String execute() throws Exception {
		
		
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		
		session.remove("admin");
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control","no-cache");

		PrintWriter pw = response.getWriter();
		pw.print("success");
		pw.flush();
		pw.close();
		
		return SUCCESS;
	}
	
}
