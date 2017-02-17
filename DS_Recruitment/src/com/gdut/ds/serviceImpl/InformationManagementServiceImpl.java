package com.gdut.ds.serviceImpl;

import java.util.List;

import com.gdut.ds.beans.informationManagement.Notice;
import com.gdut.ds.beans.informationManagement.Recruitment;
import com.gdut.ds.daoImpl.informationManagement.NoticeDaoImpl;
import com.gdut.ds.daoImpl.informationManagement.RecruitmentDaoImpl;
import com.gdut.ds.service.InformationManagementService;

public class InformationManagementServiceImpl implements
		InformationManagementService {

	private NoticeDaoImpl noticeDao;
	
	private RecruitmentDaoImpl recruitmentDao; 
	
	
	public NoticeDaoImpl getNoticeDao() {
		return noticeDao;
	}


	public void setNoticeDao(NoticeDaoImpl noticeDao) {
		this.noticeDao = noticeDao;
	}


	public RecruitmentDaoImpl getRecruitmentDao() {
		return recruitmentDao;
	}


	public void setRecruitmentDao(RecruitmentDaoImpl recruitmentDao) {
		this.recruitmentDao = recruitmentDao;
	}


	/*
	 * 发布公告
	 */
	public void releaseTheAnnouncement(Notice notice) {
		
		noticeDao.save(notice);
	}
	
	
	/*
	 * 修改公告
	 */
	public void modifyTheAnnouncement(Notice notice) {
		
		noticeDao.update(notice);
	}

	
	/*
	 * 获取全部公告信息(按时间)
	 */
	public List<Notice> getNotices() {
		
		return noticeDao.find("from Notice n Order By n.time desc");
	}
	
	
	/*
	 * 获取最新的公告信息(按时间先后前几个——数量未定)
	 */
	public List<Notice> getNewestNotices() {
		
		//String hql = "Select top 5 * from Notice n Order By n.time desc";(sqlsever版)
		
		String hql = "from Notice n Order By n.time desc limit 5";//mysql版
		
		return noticeDao.find(hql);
	}
	
	
	/*
	 * 获取详细的公告
	 */
	public Notice getTheNotice(int id) {
		
		return noticeDao.get(Notice.class, id);
	}
	
	
	/*
	 * 删除公告
	 */
	public void deleteTheAnnouncement(int id) {
		
		noticeDao.delete(Notice.class, id);
		
	}
	
	
	
	
	/*
	 * 修改招新信息
	 */
	public void modifyTheNewsOfRecruitment(Recruitment recruitment) {
		
		recruitmentDao.update(recruitment);
	}

	
	/*
	 * 发布招新信息
	 */
	public void releaseTheNewsOfRecruitment(Recruitment recruitment) {
		
		recruitmentDao.save(recruitment);
	}

	
	/*
	 * 获取全部招新信息(按时间先后)
	 */
	public List<Recruitment> getRecruitments() {
		
		return recruitmentDao.find("from Recruitment r Order By r.time desc");
	}


	/*
	 * 获取最新的招新信息（按发布时间先后）
	 */
	public List<Recruitment> getNewestRecruitments() {
		
		//String hql = "Select top 5 * from Recruitment r Order By r.time desc";(sqlsever版)
		
		String hql = "from Recruitment r Order By r.time desc limit 5";//mysql版
		
		return recruitmentDao.find(hql);
	}


	/*
	 * 获取详细的招新信息
	 */
	public Recruitment getTheRecruitment(int id) {
		
		return recruitmentDao.get(Recruitment.class, id);
	}


	/*
	 * 删除招新信息
	 */
	public void deleteTheNewsOfRecruitment(int id) {
		
		recruitmentDao.delete(Recruitment.class, id);
	}

	
	

}
