package com.gdut.ds.action.informationManagement;

import com.gdut.ds.beans.informationManagement.Notice;
import com.gdut.ds.serviceImpl.InformationManagementServiceImpl;
import com.gdut.ds.utils.TimeTools;
import com.opensymphony.xwork2.ActionSupport;

public class PublishTheNoticeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String topic;
	
	private String content;
	
	private String time;
	
	public Notice notice;
	
	private InformationManagementServiceImpl informationManagementService;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setInformationManagementService(
			InformationManagementServiceImpl informationManagementService) {
		this.informationManagementService = informationManagementService;
	}

	public InformationManagementServiceImpl getInformationManagementService() {
		return informationManagementService;
	}
	
	
	
	public String execute() throws Exception {
		
		notice.setTopic(topic);
		notice.setContent(content);
		notice.setTime(TimeTools.praseDate(time));
		
		informationManagementService.releaseTheAnnouncement(notice);
		
		return SUCCESS;
	}
	
	
}
