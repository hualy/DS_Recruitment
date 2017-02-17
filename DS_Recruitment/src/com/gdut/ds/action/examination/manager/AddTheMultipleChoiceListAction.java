package com.gdut.ds.action.examination.manager;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.examination.ExaminationQuestions;
import com.gdut.ds.beans.examination.MultipleChoice;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AddTheMultipleChoiceListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String setID;

	private String[] mtitle;
	
	private String[] optionA;
	
	private String[] optionB;
	
	private String[] optionC;
	
	private String[] optionD;
	
	private String[] mrightAnswer;
	
	private MultipleChoice multipleChoice;
	
	private ExaminationServiceImpl examinationService;
	
	public String getSetID() {
		return setID;
	}

	public void setSetID(String setID) {
		this.setID = setID;
	}

	public String[] getMtitle() {
		return mtitle;
	}

	public void setMtitle(String[] mtitle) {
		this.mtitle = mtitle;
	}

	public String[] getOptionA() {
		return optionA;
	}

	public void setOptionA(String[] optionA) {
		this.optionA = optionA;
	}

	public String[] getOptionB() {
		return optionB;
	}

	public void setOptionB(String[] optionB) {
		this.optionB = optionB;
	}

	public String[] getOptionC() {
		return optionC;
	}

	public void setOptionC(String[] optionC) {
		this.optionC = optionC;
	}

	public String[] getOptionD() {
		return optionD;
	}

	public void setOptionD(String[] optionD) {
		this.optionD = optionD;
	}

	public String[] getMrightAnswer() {
		return mrightAnswer;
	}

	public void setMrightAnswer(String[] mrightAnswer) {
		this.mrightAnswer = mrightAnswer;
	}

	public MultipleChoice getMultipleChoice() {
		return multipleChoice;
	}

	public void setMultipleChoice(MultipleChoice multipleChoice) {
		this.multipleChoice = multipleChoice;
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
		
		for(int i = 0; i < mtitle.length; i++){
			
			multipleChoice = new MultipleChoice(mtitle[i], optionA[i], optionB[i], 
					optionC[i], optionD[i], mrightAnswer[i], examinationQuestions);
			
			examinationQuestions.getMultipleChoiceList().add(multipleChoice);
			
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
