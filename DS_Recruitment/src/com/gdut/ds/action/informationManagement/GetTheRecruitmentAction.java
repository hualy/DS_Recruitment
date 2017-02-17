package com.gdut.ds.action.informationManagement;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.informationManagement.Recruitment;
import com.gdut.ds.serviceImpl.InformationManagementServiceImpl;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetTheRecruitmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private Gson gson;
	
	private InformationManagementServiceImpl informationManagementService;

	@JSON(serialize=false)
	public InformationManagementServiceImpl getInformationManagementService() {
		return informationManagementService;
	}

	public void setInformationManagementService(
			InformationManagementServiceImpl informationManagementService) {
		this.informationManagementService = informationManagementService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	

	
	@Override
	public String execute() throws Exception { 
		
		Recruitment recruitment = informationManagementService.getTheRecruitment(Integer.parseInt(id));
		
		String json = gson.toJson(recruitment);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");		//设置类型为json
		response.setHeader("Cache-Control","no-cache");

		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.flush();
		pw.close();
		
		return SUCCESS;
	}
	
}
