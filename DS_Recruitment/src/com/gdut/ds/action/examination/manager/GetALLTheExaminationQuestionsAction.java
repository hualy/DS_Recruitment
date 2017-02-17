package com.gdut.ds.action.examination.manager;

import java.util.List;
import java.util.Map;

import com.gdut.ds.beans.examination.ExaminationQuestions;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetALLTheExaminationQuestionsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ExaminationServiceImpl examinationService;

	public void setExaminationService(ExaminationServiceImpl examinationService) {
		this.examinationService = examinationService;
	}

	public ExaminationServiceImpl getExaminationService() {
		return examinationService;
	}
	
	
	@Override
	public String execute() throws Exception {
		
		Map<String, Object> request = ActionContext.getContext().getContextMap();
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("examsum") == null){
			int num = examinationService.getTheNumsOfExaminationQuestions();
			session.put("examsum", num);				//记录当前试题套总数
		}
		
		List<ExaminationQuestions> examQuestions = examinationService.getAllSetsOfExaminationQuestions();
		request.put("exams", examQuestions);
		
		
		return SUCCESS;
	}	 
	
}
