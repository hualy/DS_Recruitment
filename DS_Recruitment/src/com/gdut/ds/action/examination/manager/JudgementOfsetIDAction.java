package com.gdut.ds.action.examination.manager;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class JudgementOfsetIDAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String setID;
	
	private ExaminationServiceImpl examinationService;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSetID() {
		return setID;
	}

	public void setSetID(String setID) {
		this.setID = setID;
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
		
		String result = null;
	
		if(examinationService.getASetOfExaminationQuestions(Integer.parseInt(setID)) == null 
		   && examinationService.getASetOfExaminationQuestions(name)== null){
			
			result = "success";
		}else{
			result = "failure";
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter pw = response.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		
		return SUCCESS;
	}
	
}
