package com.gdut.ds.beans.userInfo;

public class ClassesInfo {

	private int id;										//2015级学生信息
	
	private String studentID;							//学号
	
	private String name;								//姓名

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClassesInfo() {
		
	}

	public ClassesInfo(String studentID, String name) {
	
		this.studentID = studentID;
		this.name = name;
	}
	
	
	
	
	
}
