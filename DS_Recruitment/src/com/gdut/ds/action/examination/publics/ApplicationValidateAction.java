package com.gdut.ds.action.examination.publics;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.serviceImpl.UserInfoServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ApplicationValidateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String checkCode;
	
	private UserInfoServiceImpl userInfoService;
	
	private String studentID;				//学号
	
	private String name;					//姓名

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	@JSON(serialize=false)
	public UserInfoServiceImpl getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoServiceImpl userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	
	@Override
	public String execute() throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		String result = null;
//		String realcheck = (String) session.get("checkCode");
		String realcheck = (String)ServletActionContext.getRequest().getSession().getAttribute("checkCode");
		if(!checkCode.toLowerCase().equals(realcheck)){							//验证码不正确
			
			result = "wrong";
			
		}else if(!userInfoService.matchTheStudentForm(studentID, name)){		//不是计院15新生(姓名和学号不匹配)
		
			result = "illegal";
			
		}else if(userInfoService.applicantIsExist(studentID, name)){			//报名信息已经存在，可以覆盖修改
			
			result = "exist";
			
			session.put("yourApp",userInfoService.getTheApplicant(studentID));
			
		}else{
			
			result = "success";													//成功报名
			
		}
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");		//设置类型为json
		response.setHeader("Cache-Control","no-cache");

		PrintWriter pw = response.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		
		return SUCCESS;
	}
}
