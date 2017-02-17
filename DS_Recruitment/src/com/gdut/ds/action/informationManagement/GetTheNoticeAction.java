package com.gdut.ds.action.informationManagement;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.informationManagement.Notice;
import com.gdut.ds.serviceImpl.InformationManagementServiceImpl;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetTheNoticeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private Gson gson;
	
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

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}


	
	
	@Override
	public String execute() throws Exception {

		
		Notice notice = informationManagementService.getTheNotice(Integer.parseInt(id));
		
		String json = gson.toJson(notice);
		
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
