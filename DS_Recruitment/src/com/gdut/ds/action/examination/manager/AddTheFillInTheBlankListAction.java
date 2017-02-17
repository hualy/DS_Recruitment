package com.gdut.ds.action.examination.manager;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.examination.ExaminationQuestions;
import com.gdut.ds.beans.examination.FillInTheBlank;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AddTheFillInTheBlankListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String setID;
	
	private String[] ftitle;
	
	private String[] frightAnswer;
	
	private FillInTheBlank fillInTheBlank;
	
	private ExaminationServiceImpl examinationService;

	public String getSetID() {
		return setID;
	}

	public void setSetID(String setID) {
		this.setID = setID;
	}

	public String[] getFtitle() {
		return ftitle;
	}

	public void setFtitle(String[] ftitle) {
		this.ftitle = ftitle;
	}

	public String[] getFrightAnswer() {
		return frightAnswer;
	}

	public void setFrightAnswer(String[] frightAnswer) {
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
		
		ExaminationQuestions examinationQuestions = examinationService.getASetOfExaminationQuestions(Integer.parseInt(setID));
		for(int i = 0; i < ftitle.length; i++){
			
			fillInTheBlank = new FillInTheBlank(ftitle[i], frightAnswer[i], examinationQuestions);
			examinationQuestions.getFillInTheBlankList().add(fillInTheBlank);
		}
		examinationService.reviseTheSetOfExaminationQuestions(examinationQuestions);
		
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
