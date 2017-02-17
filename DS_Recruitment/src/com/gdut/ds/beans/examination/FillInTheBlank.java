package com.gdut.ds.beans.examination;


public class FillInTheBlank implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;							//填空题id号
	
	private String title;					//填空题题目
	
	private String rightAnswer;				//正确答案
	
	private String[] real;					//真正的答案数组
	
	private ExaminationQuestions examinationQuestions;	//所属于的试题对象
	
	public FillInTheBlank(){
		
	}
	

	public FillInTheBlank(String title, String rightAnswer,ExaminationQuestions examinationQuestions) {
	
		this.title = title;
		this.rightAnswer = rightAnswer;
		this.examinationQuestions = examinationQuestions;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public void setExaminationQuestions(ExaminationQuestions examinationQuestions) {
		this.examinationQuestions = examinationQuestions;
	}


	public ExaminationQuestions getExaminationQuestions() {
		return examinationQuestions;
	}


	public void setReal(String[] real) {
		this.real = real;
	}


	public String[] getReal() {
		return real;
	}
	
}
