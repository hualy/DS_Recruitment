package com.gdut.ds.action.examination.manager;

import java.util.List;
import java.util.Map;

import com.gdut.ds.beans.examination.InformationForExam;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllInformationForExamAction extends ActionSupport {


	private static final long serialVersionUID = 1L;

	private ExaminationServiceImpl examinationService;

	public ExaminationServiceImpl getExaminationService() {
		return examinationService;
	}

	public void setExaminationService(ExaminationServiceImpl examinationService) {
		this.examinationService = examinationService;
	}
	
	
	@Override
	public String execute() throws Exception {
		
		Map<String, Object> request = ActionContext.getContext().getContextMap();
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		List<InformationForExam> infoList = (List<InformationForExam>) examinationService.getAllTheInformationForExam();
		request.put("examInfo", infoList);
		
		if(session.get("examnum") == null){
		
			int num = examinationService.getTheNumsOfExaminationQuestions();
			session.put("examsum", num);
		}
		
		return SUCCESS;
	}
	
	
}
