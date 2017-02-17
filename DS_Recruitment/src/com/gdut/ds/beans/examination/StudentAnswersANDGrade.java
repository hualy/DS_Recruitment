package com.gdut.ds.beans.examination;

import java.util.Date;
import java.util.List;

import com.gdut.ds.beans.userInfo.Applicant;

public class StudentAnswersANDGrade implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;													//学生考试成绩单id号
	
	private Date beginTime;											//考试开始时间
	
	private String timeOfExamination;								//考试用时
	
	private int firstGrade;											//初评成绩
	
	private int finalGrade;											//最终成绩
	
	private List<ProceduralQuestionsAnswer> proceduralQuestionsAnswerList;	//程序题的答案
	
	private Applicant applicant;									//考生信息
	
	private ExamPaper examPaper;									//考生所答的试卷

	
	
	public StudentAnswersANDGrade(){
		
	}
	

	public StudentAnswersANDGrade(Date beginTime, String timeOfExamination,
			int firstGrade, int finalGrade,
			List<ProceduralQuestionsAnswer> proceduralQuestionsAnswerList,
			Applicant applicant, ExamPaper examPaper) {
		
		this.beginTime = beginTime;
		this.timeOfExamination = timeOfExamination;
		this.firstGrade = firstGrade;
		this.finalGrade = finalGrade;
		this.proceduralQuestionsAnswerList = proceduralQuestionsAnswerList;
		this.applicant = applicant;
		this.examPaper = examPaper;
	}



	public List<ProceduralQuestionsAnswer> getProceduralQuestionsAnswerList() {
		return proceduralQuestionsAnswerList;
	}

	public void setProceduralQuestionsAnswerList(
			List<ProceduralQuestionsAnswer> proceduralQuestionsAnswerList) {
		this.proceduralQuestionsAnswerList = proceduralQuestionsAnswerList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimeOfExamination() {
		return timeOfExamination;
	}

	public void setTimeOfExamination(String timeOfExamination) {
		this.timeOfExamination = timeOfExamination;
	}

	public int getFirstGrade() {
		return firstGrade;
	}

	public void setFirstGrade(int firstGrade) {
		this.firstGrade = firstGrade;
	}

	public int getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}
	

	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}

	public ExamPaper getExamPaper() {
		return examPaper;
	}


	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}


	public Applicant getApplicant() {
		return applicant;
	}


	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}


	public Date getBeginTime() {
		return beginTime;
	}
	
	
	
	
}
