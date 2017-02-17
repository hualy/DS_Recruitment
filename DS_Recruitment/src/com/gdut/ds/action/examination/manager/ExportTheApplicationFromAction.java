package com.gdut.ds.action.examination.manager;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.gdut.ds.beans.userInfo.Applicant;
import com.gdut.ds.serviceImpl.UserInfoServiceImpl;
import com.gdut.ds.utils.ExportTheApplicationFrom;
import com.opensymphony.xwork2.ActionSupport;

public class ExportTheApplicationFromAction extends ActionSupport {


	private static final long serialVersionUID = 1L;

	private UserInfoServiceImpl userInfoService;
	
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@JSON(serialize=false)
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		return freeMarkerConfigurer;
	}

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}
	@JSON(serialize=false)
	public UserInfoServiceImpl getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoServiceImpl userInfoService) {
		this.userInfoService = userInfoService;
	}




	@SuppressWarnings("deprecation")
	@Override
	public String execute() throws Exception {
		
		
		List<Applicant> applicants = userInfoService.getAllTheApplicantsInfo();
		
		String exportPath = ServletActionContext.getRequest().getRealPath("/export/");
		
		String address = null;
		
		
		ExportTheApplicationFrom export = new ExportTheApplicationFrom(exportPath);
		export.setFreeMarkerConfigurer(freeMarkerConfigurer);
		
		if(export.createDoc(applicants)){
			
			export.packSomeFiles();
			
			address =  "/export/zip/考生报名信息.zip";
			
		}else{
			
			address = "failure";
		}
		
		System.out.println(address);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");		//设置类型为json
		response.setHeader("Cache-Control","no-cache");

		PrintWriter pw = response.getWriter();
		pw.print(address);
		pw.flush();
		pw.close();
		
		
		return SUCCESS;
	}
	
}
