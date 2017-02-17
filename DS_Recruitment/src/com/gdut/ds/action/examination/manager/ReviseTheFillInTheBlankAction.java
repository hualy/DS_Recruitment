package com.gdut.ds.action.examination.manager;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.examination.FillInTheBlank;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ReviseTheFillInTheBlankAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String fid;

	private String ftitle;
	
	private String frightAnswer;
	
	private FillInTheBlank fillInTheBlank;
	
	private ExaminationServiceImpl examinationService;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public String getFrightAnswer() {
		return frightAnswer;
	}

	public void setFrightAnswer(String frightAnswer) {
		this.frightAnswer = frightAnswer;
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
		
		String result = "success";
		
		fillInTheBlank = examinationService.getFillInTheBlank(Integer.parseInt(fid));
		fillInTheBlank.setTitle(ftitle);
		fillInTheBlank.setRightAnswer(frightAnswer);
		examinationService.reviseFillInTheBlank(fillInTheBlank);
		
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
