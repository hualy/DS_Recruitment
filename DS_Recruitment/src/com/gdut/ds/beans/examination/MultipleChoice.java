package com.gdut.ds.beans.examination;


public class MultipleChoice implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;							//选择题 id号
	
	private String title;					//题目
	
	private String optionA;  				//选项A
	
	private String optionB;					//选项B
	
	private String optionC;					//选项C
	
	private String optionD;					//选项D
	
	private String rightAnswer;				//正确答案
	
	private ExaminationQuestions examinationQuestions;	//所属于的试题对象
	
	
	public MultipleChoice(){
		
	}
	
	
	public MultipleChoice(String title, String optionA,
			String optionB, String optionC, String optionD, String rightAnswer,
			ExaminationQuestions examinationQuestions) {
	
		this.title = title;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
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
	

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
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


}
