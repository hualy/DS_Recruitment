package com.gdut.ds.action.userInfo;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.examination.StudentAnswersANDGrade;
import com.gdut.ds.beans.userInfo.Applicant;
import com.gdut.ds.serviceImpl.UserInfoServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SaveApplicantInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String studentID;				//学号
	
	private String name;					//姓名
	
	private String sex;						//性别
	
	private String academy;					//学院
	
	private String major;					//专业
	
	private String grade;					//班级
	
	private String job;						//职务
	
	private String phoneNumber;				//手机号码
	
	private String QQ;						//QQ
	
	private String email;					//邮箱
	
	private String aspect;					//报名方向
	
	private String shortphoneNumber;		//短号		
	
	private String skills;					//技能
	
	private String hopes;					//期望
	
	private String selfevaluation;			//自我评价
	
	private Applicant applicant;
	
	private StudentAnswersANDGrade stuGrade;
	
	private UserInfoServiceImpl userInfoService;
	

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@JSON(serialize=false)
	public UserInfoServiceImpl getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoServiceImpl userInfoService) {
		this.userInfoService = userInfoService;
	}

	public String getShortphoneNumber() {
		return shortphoneNumber;
	}

	public void setShortphoneNumber(String shortphoneNumber) {
		this.shortphoneNumber = shortphoneNumber;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getHopes() {
		return hopes;
	}

	public void setHopes(String hopes) {
		this.hopes = hopes;
	}

	public String getSelfevaluation() {
		return selfevaluation;
	}

	public void setSelfevaluation(String selfevaluation) {
		this.selfevaluation = selfevaluation;
	}

	@JSON(serialize=false)
	public StudentAnswersANDGrade getStuGrade() {
		return stuGrade;
	}

	public void setStuGrade(StudentAnswersANDGrade stuGrade) {
		this.stuGrade = stuGrade;
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

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAspect() {
		return aspect;
	}

	public void setAspect(String aspect) {
		this.aspect = aspect;
	}

	@JSON(serialize=false)
	public Applicant getApplicant() {
		return applicant;
	}

	
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}


	
	@Override
	public String execute() throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();

//		stuGrade.setApplicant(applicant);
//		stuGrade.setFirstGrade(0);
//		stuGrade.setFinalGrade(0);
//		applicant.setStudentAnswersANDGrade(stuGrade);
//			
//		session.put("applicant", applicant);
	
		
		if((Applicant) session.get("yourApp") == null){
			
			applicant.setStudentID(studentID);
			applicant.setSex(sex);
			applicant.setName(name);
			applicant.setAcademy(academy);
			applicant.setGrade(grade);
			applicant.setMajor(major);
			applicant.setJob(job);
			applicant.setPhoneNumber(phoneNumber);
			applicant.setQQ(QQ);
			applicant.setEmail(email);
			applicant.setAspect(aspect);
			applicant.setTime(new Date());
			applicant.setShortphoneNumber(shortphoneNumber);
			applicant.setSkills(skills);
			applicant.setSelfevaluation(selfevaluation);
			applicant.setHopes(hopes);
			
			userInfoService.signUpOnline(applicant);		//保存报名信息
			
		}else{
			
			applicant = (Applicant) session.get("yourApp");
			applicant.setStudentID(studentID);
			applicant.setSex(sex);
			applicant.setName(name);
			applicant.setAcademy(academy);
			applicant.setGrade(grade);
			applicant.setMajor(major);
			applicant.setJob(job);
			applicant.setPhoneNumber(phoneNumber);
			applicant.setQQ(QQ);
			applicant.setEmail(email);
			applicant.setAspect(aspect);
			applicant.setTime(new Date());
			applicant.setShortphoneNumber(shortphoneNumber);
			applicant.setSkills(skills);
			applicant.setSelfevaluation(selfevaluation);
			applicant.setHopes(hopes);
			
			userInfoService.updateTheApplicant(applicant);	//更新报名信息
		}
			
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");		//设置类型为json
		response.setHeader("Cache-Control","no-cache");

		PrintWriter pw = response.getWriter();
		pw.print("success");
		pw.flush();
		pw.close();
		
		return SUCCESS;
			
	}
	
}
