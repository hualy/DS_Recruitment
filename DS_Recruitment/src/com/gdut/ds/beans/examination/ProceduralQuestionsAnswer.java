package com.gdut.ds.beans.examination;


public class ProceduralQuestionsAnswer implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;												//程序题答案id
	
	private String code; 										//考生的代码答案
	
	private StudentAnswersANDGrade studentAnswersANDGrade;		//考试情况

	
	public ProceduralQuestionsAnswer(){
		
	}

	
	public ProceduralQuestionsAnswer(String code, StudentAnswersANDGrade studentAnswersANDGrade) {

		this.code = code;
		this.studentAnswersANDGrade = studentAnswersANDGrade;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStudentAnswersANDGrade(StudentAnswersANDGrade studentAnswersANDGrade) {
		this.studentAnswersANDGrade = studentAnswersANDGrade;
	}

	public StudentAnswersANDGrade getStudentAnswersANDGrade() {
		return studentAnswersANDGrade;
	}
	
}
