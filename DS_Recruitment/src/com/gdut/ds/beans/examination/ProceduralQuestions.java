package com.gdut.ds.beans.examination;


public class ProceduralQuestions implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;							//程序题id号
	
	private String title;					//题目
	
	
	private ExaminationQuestions examinationQuestions;	//所属于的试题对象

	
	public ProceduralQuestions(){
		
	}

	
	public ProceduralQuestions(String title, ExaminationQuestions examinationQuestions) {

		this.title = title;
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
	

	public void setExaminationQuestions(ExaminationQuestions examinationQuestions) {
		this.examinationQuestions = examinationQuestions;
	}


	public ExaminationQuestions getExaminationQuestions() {
		return examinationQuestions;
	}


	
}
