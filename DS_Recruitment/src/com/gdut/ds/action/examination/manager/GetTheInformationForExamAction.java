package com.gdut.ds.action.examination.manager;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.examination.InformationForExam;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetTheInformationForExamAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private Gson gson;
	
	private ExaminationServiceImpl examinationService;
	
	private InformationForExam informationForExam;

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JSON(serialize=false)
	public ExaminationServiceImpl getExaminationService() {
		return examinationService;
	}

	public void setExaminationService(ExaminationServiceImpl examinationService) {
		this.examinationService = examinationService;
	}
	
	
	@Override
	public String execute() throws Exception {
		
		informationForExam = examinationService.getTheInformationForExam(Integer.parseInt(id));
		
		String json = gson.toJson(informationForExam);
		
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
