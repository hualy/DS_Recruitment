package com.gdut.ds.action.examination.manager;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.examination.ExaminationQuestions;
import com.gdut.ds.beans.examination.ProceduralQuestions;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AddTheProceduralQuestionsListAction extends ActionSupport {


	private static final long serialVersionUID = 1L;

	private String setID;
	
	private String[] ptitle;
	
	private ProceduralQuestions proceduralQuestions;
	
	private ExaminationServiceImpl examinationService;

	public String getSetID() {
		return setID;
	}

	public void setSetID(String setID) {
		this.setID = setID;
	}

	public String[] getPtitle() {
		return ptitle;
	}

	public void setPtitle(String[] ptitle) {
		this.ptitle = ptitle;
	}

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
		for(int i = 0; i < ptitle.length; i++){
			
			proceduralQuestions = new ProceduralQuestions(ptitle[i], examinationQuestions);
			examinationQuestions.getProceduralQuestionsList().add(proceduralQuestions);
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
