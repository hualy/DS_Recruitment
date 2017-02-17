package com.gdut.ds.action.examination.publics;

import java.util.List;
import java.util.Map;

import com.gdut.ds.beans.examination.ProceduralQuestionsAnswer;
import com.gdut.ds.beans.userInfo.Applicant;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.gdut.ds.serviceImpl.UserInfoServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FirstScoringAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ExaminationServiceImpl examinationService;
	
	private String[] multipleChoiceAnswer;						//选择题答案
	
	private String[] fillInTheBlankAnswer;						//填空题答案
	
	private String[] PQAnswer;									//程序题答案
	
	private List<ProceduralQuestionsAnswer> proceduralQuestionsAnswerList;
	
	private UserInfoServiceImpl userInfoService;
	
	
	public String[] getPQAnswer() {
		return PQAnswer;
	}


	public void setPQAnswer(String[] pQAnswer) {
		PQAnswer = pQAnswer;
	}

	public String[] getMultipleChoiceAnswer() {
		return multipleChoiceAnswer;
	}


	public void setMultipleChoiceAnswer(String[] multipleChoiceAnswer) {
		this.multipleChoiceAnswer = multipleChoiceAnswer;
	}


	public String[] getFillInTheBlankAnswer() {
		return fillInTheBlankAnswer;
	}


	public void setFillInTheBlankAnswer(String[] fillInTheBlankAnswer) {
		this.fillInTheBlankAnswer = fillInTheBlankAnswer;
	}


	public UserInfoServiceImpl getUserInfoService() {
		return userInfoService;
	}


	public void setUserInfoService(UserInfoServiceImpl userInfoService) {
		this.userInfoService = userInfoService;
	}


	public ExaminationServiceImpl getExaminationService() {
		return examinationService;
	}


	public void setExaminationService(ExaminationServiceImpl examinationService) {
		this.examinationService = examinationService;
	}


	@Override
	public String execute() throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		Applicant applicant = (Applicant) session.get("applicant");
		
		if(userInfoService.applicantIsExist(applicant.getStudentID(), applicant.getName())){			//判断考生是否以考试
			
			return INPUT;
		}
		
		examinationService.firstMarking(multipleChoiceAnswer, fillInTheBlankAnswer, 
				applicant.getStudentAnswersANDGrade(), applicant.getStudentAnswersANDGrade().getExamPaper());
		
		for(int i = 0; i < PQAnswer.length; i++){
			
			ProceduralQuestionsAnswer pq = new ProceduralQuestionsAnswer();		//没有用spring注入不太好
			pq.setCode(PQAnswer[i]);
			pq.setStudentAnswersANDGrade(applicant.getStudentAnswersANDGrade());
			
			proceduralQuestionsAnswerList.add(pq);
		}
		applicant.getStudentAnswersANDGrade().setProceduralQuestionsAnswerList(proceduralQuestionsAnswerList);
		applicant.setFinished(1);									//以进行过考试
		
		userInfoService.signUpOnline(applicant);					//保存考生相关信息到数据库
		session.remove("applicant");								//会话清除考生信息和考试信息
		session.remove("informationForExam");
		
		return SUCCESS;
	}

}
