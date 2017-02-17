package com.gdut.ds.serviceImpl;


import java.util.List;

import com.gdut.ds.beans.userInfo.Admin;
import com.gdut.ds.beans.userInfo.Administrator;
import com.gdut.ds.beans.userInfo.Applicant;
import com.gdut.ds.daoImpl.informationManagement.ApplicantDaoImpl;
import com.gdut.ds.daoImpl.userInfo.ClassesInfoDaoImpl;
import com.gdut.ds.service.UserInfoService;
import com.gdut.ds.utils.MD5;

public class UserInfoServiceImpl implements UserInfoService {
	
	
	private boolean result = false;
	
	private ApplicantDaoImpl applicantDao;
	
	private ClassesInfoDaoImpl classesInfoDao;
	
	public ClassesInfoDaoImpl getClassesInfoDao() {
		return classesInfoDao;
	}


	public void setClassesInfoDao(ClassesInfoDaoImpl classesInfoDao) {
		this.classesInfoDao = classesInfoDao;
	}


	public ApplicantDaoImpl getApplicantDao() {
		return applicantDao;
	}


	public void setApplicantDao(ApplicantDaoImpl applicantDao) {
		this.applicantDao = applicantDao;
	}

	

	/*
	 * 管理员登录验证
	 */
	public boolean adminLogin(Admin admin) {
		
//		System.out.printf(MD5.MD5Run(admin.getPassword()).toString());
//		System.out.println(MD5.MD5Run(Administrator.password).toString());
		
		if(admin.getUsername().equals(Administrator.username) ){
			
			byte[] p1 = MD5.MD5Run(admin.getPassword());
			byte[] p2 = MD5.MD5Run(Administrator.password);
			
			result = MD5.compareTo(p1, p2);
		}
		
		return result;
	}

	
	/*
	 * 提交报名和考试
	 */
	public void signUpOnline(Applicant applicant) {
	
		applicantDao.save(applicant);
	}


	/*
	 * 判断用户是否存在
	 */
	public boolean applicantIsExist(String studentID, String name) {
		
		Applicant app = applicantDao.findByHQL("from Applicant a where a.studentID = ? and a.name = ? and a.finished = 0", studentID, name);
		
		if(app != null){
			
			return true;
		}
		
		return false;
	}


	/*
	 *获取所有考生报名信息
	 */
	public List<Applicant> getAllTheApplicantsInfo() {

		
		return applicantDao.findAll(Applicant.class);
	}


	/*
	 * 获取特定报名信息
	 */
	public Applicant getTheApplicant(String studentID) {
	
		return applicantDao.findByHQL("From Applicant a where a.studentID = ?", studentID);
	}


	/*
	 * 更新报名人信息
	 */
	public void updateTheApplicant(Applicant applicant) {
		
		applicantDao.update(applicant);
		
	}


	/*
	 * 	根据学号判断考生是否报名
	 */
	public boolean applicantIsExist(String studentID) {
		
		if((applicantDao.findByHQL("From Applicant a where a.studentID = ?", studentID)) != null){
			
			return true;
		}
		
		return false;
	}


	/*
	 * 匹配15新生名单
	 */
	public boolean matchTheStudentForm(String studentID, String name) {
		
		if((classesInfoDao.findByHQL("From ClassesInfo c where c.studentID = ? and c.name = ?",studentID,name)) != null){
			
			return true;			//匹配成功
			
		}
		
		return false;
	}


}
