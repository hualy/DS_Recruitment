package com.gdut.ds.beans.userInfo;

import java.util.Date;

import com.gdut.ds.beans.examination.StudentAnswersANDGrade;

public class Applicant implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;							//id号
	
	private String studentID;				//学号
	
	private String name;					//姓名
	
	private String sex;						//性别
	
	private String academy;					//学院
	
	private String major;					//专业
	
	private String grade;					//班级
	
	private String job;						//现任职务
	
	private String phoneNumber;				//电话号码
	
	private String shortphoneNumber;		//短号
	
	private String QQ;						//QQ
	
	private String email;					//邮箱地址
	
	private String aspect;					//报名方向
	
	private String skills;					//个人技能经验
	
	private String hopes;					//加入团队的目的及期望
	
	private String selfevaluation;			//自我评价
	
	private Date time;						//报名时间
	
	private int finished = 0;				//是否进行过考试
	
	private StudentAnswersANDGrade studentAnswersANDGrade;	//考生考试情况

	

	public Applicant(){
		
	}
	
	public Applicant(String studentID, String name, String sex, String academy,
			String major, String grade, String job, String phoneNumber,
			String shortphoneNumber, String qQ, String email, String aspect,
			String skills, String hopes,
			String selfevaluation, Date time, int finished,
			StudentAnswersANDGrade studentAnswersANDGrade) {
		
		this.studentID = studentID;
		this.name = name;
		this.sex = sex;
		this.academy = academy;
		this.major = major;
		this.grade = grade;
		this.job = job;
		this.phoneNumber = phoneNumber;
		this.shortphoneNumber = shortphoneNumber;
		this.QQ = qQ;
		this.email = email;
		this.aspect = aspect;
		this.skills = skills;
		this.hopes = hopes;
		this.selfevaluation = selfevaluation;
		this.time = time;
		this.finished = finished;
		this.studentAnswersANDGrade = studentAnswersANDGrade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAspect() {
		return aspect;
	}

	public void setAspect(String aspect) {
		this.aspect = aspect;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getFinished() {
		return finished;
	}

	public void setFinished(int finished) {
		this.finished = finished;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentAnswersANDGrade(StudentAnswersANDGrade studentAnswersANDGrade) {
		this.studentAnswersANDGrade = studentAnswersANDGrade;
	}

	public StudentAnswersANDGrade getStudentAnswersANDGrade() {
		return studentAnswersANDGrade;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getQQ() {
		return QQ;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setShortphoneNumber(String shortphoneNumber) {
		this.shortphoneNumber = shortphoneNumber;
	}

	public String getShortphoneNumber() {
		return shortphoneNumber;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSkills() {
		return skills;
	}

	public void setHopes(String hopes) {
		this.hopes = hopes;
	}

	public String getHopes() {
		return hopes;
	}

	public void setSelfevaluation(String selfevaluation) {
		this.selfevaluation = selfevaluation;
	}

	public String getSelfevaluation() {
		return selfevaluation;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public String getJob() {
		return job;
	}

	
	
	
}
