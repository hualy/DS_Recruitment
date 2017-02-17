package com.gdut.ds.beans.examination;

import java.util.List;


public class ExamPaper implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;													//id号
	
	private int mscore;												//每道选择题的分数
	
	private int fscore;												//每道填空题的分数
	
	private int pscore;		
	
	private List<MultipleChoice> multipleChoiceList;				//选择题
	
	private List<FillInTheBlank> fillInTheBlankList;				//填空题
	
	private List<ProceduralQuestions> proceduralQuestionsList;		//程序题
	
	private StudentAnswersANDGrade studentAnswersANDGrade;			//考试情况 
	
	
	public ExamPaper(){
		
	}
	
	
	public ExamPaper(int mscore, int fscore, int pscore,
			List<MultipleChoice> multipleChoiceList,
			List<FillInTheBlank> fillInTheBlankList,
			List<ProceduralQuestions> proceduralQuestionsList,
			StudentAnswersANDGrade studentAnswersANDGrade) {
		
		this.mscore = mscore;
		this.fscore = fscore;
		this.pscore = pscore;
		this.multipleChoiceList = multipleChoiceList;
		this.fillInTheBlankList = fillInTheBlankList;
		this.proceduralQuestionsList = proceduralQuestionsList;
		this.studentAnswersANDGrade = studentAnswersANDGrade;
	}


	public int getMscore() {
		return mscore;
	}

	public void setMscore(int mscore) {
		this.mscore = mscore;
	}

	public int getFscore() {
		return fscore;
	}

	public void setFscore(int fscore) {
		this.fscore = fscore;
	}

	public int getPscore() {
		return pscore;
	}

	public void setPscore(int pscore) {
		this.pscore = pscore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<MultipleChoice> getMultipleChoiceList() {
		return multipleChoiceList;
	}

	public void setMultipleChoiceList(List<MultipleChoice> multipleChoiceList) {
		this.multipleChoiceList = multipleChoiceList;
	}

	public List<FillInTheBlank> getFillInTheBlankList() {
		return fillInTheBlankList;
	}

	public void setFillInTheBlankList(List<FillInTheBlank> fillInTheBlankList) {
		this.fillInTheBlankList = fillInTheBlankList;
	}

	public List<ProceduralQuestions> getProceduralQuestionsList() {
		return proceduralQuestionsList;
	}

	public void setProceduralQuestionsList(
			List<ProceduralQuestions> proceduralQuestionsList) {
		this.proceduralQuestionsList = proceduralQuestionsList;
	}

	public StudentAnswersANDGrade getStudentAnswersANDGrade() {
		return studentAnswersANDGrade; 
	}

	public void setStudentAnswersANDGrade(
			StudentAnswersANDGrade studentAnswersANDGrade) {
		this.studentAnswersANDGrade = studentAnswersANDGrade;
	}

	
}
