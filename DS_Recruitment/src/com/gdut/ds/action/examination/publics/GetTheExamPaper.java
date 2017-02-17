package com.gdut.ds.action.examination.publics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gdut.ds.beans.examination.ExamPaper;
import com.gdut.ds.beans.examination.ExaminationQuestions;
import com.gdut.ds.beans.examination.FillInTheBlank;
import com.gdut.ds.beans.examination.MultipleChoice;
import com.gdut.ds.beans.examination.ProceduralQuestions;
import com.gdut.ds.beans.userInfo.Applicant;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.gdut.ds.utils.RandomTool;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetTheExamPaper extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ExaminationServiceImpl examinationService;
	
	private ExamPaper examPaper;

	public ExamPaper getExamPaper() {
		return examPaper;
	}

	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}

	public void setExaminationService(ExaminationServiceImpl examinationService) {
		this.examinationService = examinationService;
	}

	public ExaminationServiceImpl getExaminationService() {
		return examinationService;
	}
	
	
	@Override
	public String execute() throws Exception {
		
		Map<String, Object> application = ActionContext.getContext().getApplication();
		Map<String, Object> session = ActionContext.getContext().getSession();
		int num = 4;												//题目数量
		
		ExaminationQuestions examinationQuestions = (ExaminationQuestions) application.get("examinationQuestions");
		List<MultipleChoice> mList = examinationQuestions.getMultipleChoiceList();
		List<FillInTheBlank> fList = examinationQuestions.getFillInTheBlankList();
		
		List<MultipleChoice> multipleChoiceList = new ArrayList<MultipleChoice>();
		List<FillInTheBlank> fillInTheBlankList = new ArrayList<FillInTheBlank>();
		
		//随机组题
		int[] m = RandomTool.randomCommon(1, mList.size(), num);
		int[] f = RandomTool.randomCommon(1, fList.size(), num);
		
		for(int i = 0; i < m.length; i++){
			
			multipleChoiceList.add(mList.get(m[i] - 1));
		}
		for(int j = 0; j < f.length; j++){
			
			fillInTheBlankList.add(fList.get(f[j] - 1));
		}
		
		List<ProceduralQuestions> proceduralQuestionsList = examinationQuestions.getProceduralQuestionsList();
		examPaper.setMultipleChoiceList(multipleChoiceList);
		examPaper.setFillInTheBlankList(fillInTheBlankList);
		examPaper.setProceduralQuestionsList(proceduralQuestionsList);
		
		Applicant applicant = (Applicant) session.get("applicant");
		applicant.getStudentAnswersANDGrade().setExamPaper(examPaper);
		examPaper.setStudentAnswersANDGrade(applicant.getStudentAnswersANDGrade());
		
		session.put("applicant", applicant);
		
		return SUCCESS;
	}
	
	
}
