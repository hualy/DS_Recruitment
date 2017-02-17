package com.gdut.ds.action.examination.manager;

import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.examination.ExaminationQuestions;
import com.gdut.ds.beans.examination.FillInTheBlank;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.gdut.ds.utils.ExamTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetTheSetOfExaminationQuestionsAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;

	private ExaminationServiceImpl examinationService;

	private String id;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setExaminationService(ExaminationServiceImpl examinationService) {
		this.examinationService = examinationService;
	}

	@JSON(serialize=false)
	public ExaminationServiceImpl getExaminationService() {
		return examinationService;
	}
	
	
	@Override
	public String execute() throws Exception {
		
		ExaminationQuestions examQuestions = examinationService.getASetOfExaminationQuestions(Integer.parseInt(id));
		
		List<FillInTheBlank> fList = examQuestions.getFillInTheBlankList();
		
		for(int i = 0; i < fList.size(); i++){						//划分填空题
			
			fList.get(i).setReal(ExamTools.divideAnswers(fList.get(i).getRightAnswer()));
			
		}
		examQuestions.setFillInTheBlankList(fList);
		
		Map<String, Object> request = ActionContext.getContext().getContextMap();
		request.put("examQuestions", examQuestions);
		
		return SUCCESS;
	}
	
}
