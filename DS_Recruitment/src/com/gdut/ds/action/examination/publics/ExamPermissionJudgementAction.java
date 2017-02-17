package com.gdut.ds.action.examination.publics;

import java.util.Date;
import java.util.Map;

import com.gdut.ds.beans.examination.InformationForExam;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExamPermissionJudgementAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date date;

	private ExaminationServiceImpl examinationService;
	
	private InformationForExam informationForExam;

	public void setExaminationService(ExaminationServiceImpl examinationService) {
		this.examinationService = examinationService;
	}


	public ExaminationServiceImpl getExaminationService() {
		return examinationService;
	}
	
	@Override
	public String execute() throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		date = new Date();
		
		if(session.get("informationForExam") == null){
			
			informationForExam = examinationService.getTheNOTFinshedExamInfo();
			
		}else{
			
			informationForExam = (InformationForExam) session.get("informationForExam");
		}
		
		session.put("informationForExam", informationForExam);
		if(informationForExam.getBeginTime().compareTo(date) >= 1){		//考试时间到了(还要添加MAC地址的判断)
			
			return SUCCESS;
			
		}
		
		return INPUT;
	}

	
}
