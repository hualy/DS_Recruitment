package com.gdut.ds.action.userInfo;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.userInfo.Admin;
import com.gdut.ds.serviceImpl.UserInfoServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private Admin admin;
	
	private UserInfoServiceImpl userInfoService;
	
	private String result;

	@JSON(serialize=false)
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@JSON(serialize=false)
	public UserInfoServiceImpl getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoServiceImpl userInfoService) {
		this.userInfoService = userInfoService;
	}

	 @JSON(serialize=false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	 @JSON(serialize=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String execute() throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		admin.setUsername(username);
		admin.setPassword(password);
		
		if(userInfoService.adminLogin(admin)){
			
			result = "success";
			
			session.put("admin", admin.getUsername());
			
		}else{
			
			result = "failure";
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control","no-cache");

		PrintWriter pw = response.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		
		return SUCCESS;
	}
	
	
	
	
	
	
}
