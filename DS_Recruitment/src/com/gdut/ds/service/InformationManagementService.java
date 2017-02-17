package com.gdut.ds.service;

import java.util.List;

import com.gdut.ds.beans.informationManagement.Notice;
import com.gdut.ds.beans.informationManagement.Recruitment;

public interface InformationManagementService {

	public void releaseTheAnnouncement(Notice notice);						//发布公告
	
	public void modifyTheAnnouncement(Notice notice);						//修改公告
	
	public void deleteTheAnnouncement(int id);								//删除公告
	
	public List<Notice> getNotices();										//获取全部公告(按时间顺序)
	
	public List<Notice> getNewestNotices();									//获取最新的公告
	
	public Notice getTheNotice(int id);										//根据id获取详细公告信息
	
	
	
	
	public List<Recruitment> getRecruitments();								//获取全部招新信息（按时间顺序）
	
	public List<Recruitment> getNewestRecruitments();						//获取最新的招新信息
	
	public Recruitment getTheRecruitment(int id);							//根据id获取详细的招新信息
	
	public void releaseTheNewsOfRecruitment(Recruitment recruitment);		//发布招新信息
	
	public void modifyTheNewsOfRecruitment(Recruitment recruitment);		//修改招新信息
	
	public void deleteTheNewsOfRecruitment(int id);							//删除招新信息
}
