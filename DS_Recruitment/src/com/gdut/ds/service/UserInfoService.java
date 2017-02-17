package com.gdut.ds.service;

import java.util.List;

import com.gdut.ds.beans.userInfo.Admin;
import com.gdut.ds.beans.userInfo.Applicant;

public interface UserInfoService {

	public void signUpOnline(Applicant applicant);						//网上报名
	
	public boolean adminLogin(Admin admin);								//管理员登录
	
	public List<Applicant> getAllTheApplicantsInfo(); 					//获取所有考生报名信息
	
	public Applicant getTheApplicant(String studentID);					//通过学号获取考生信息
	
	public void updateTheApplicant(Applicant applicant);				//更新报名学生的信息		
	
	public boolean applicantIsExist(String studentID);					//通过学号判断考生是否报名
	
	public boolean applicantIsExist(String studentID, String name);		//判断考生是否已提交申请

	public boolean matchTheStudentForm(String studentID, String name);	//匹配15届新生
	
}
