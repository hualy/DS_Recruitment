package com.gdut.ds.action.informationManagement;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.serviceImpl.InformationManagementServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteTheRecruitmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private InformationManagementServiceImpl informationManagementService;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JSON(serialize=false)
	public InformationManagementServiceImpl getInformationManagementService() {
		return informationManagementService;
	}

	public void setInformationManagementService(
			InformationManagementServiceImpl informationManagementService) {
		this.informationManagementService = informationManagementService;
	}
	
	

	@Override
	public String execute() throws Exception {
	
		informationManagementService.deleteTheNewsOfRecruitment(Integer.parseInt(id));
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");		//设置类型为json
		response.setHeader("Cache-Control","no-cache");

		PrintWriter pw = response.getWriter();
		pw.print(id);
		pw.flush();
		pw.close();
		
		return SUCCESS;
	}
	
}
