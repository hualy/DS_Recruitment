package com.gdut.ds.action.informationManagement;

import com.gdut.ds.beans.informationManagement.Recruitment;
import com.gdut.ds.serviceImpl.InformationManagementServiceImpl;
import com.gdut.ds.utils.TimeTools;
import com.opensymphony.xwork2.ActionSupport;

public class PublishTheRecruitmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InformationManagementServiceImpl informationManagementService;
	
	private Recruitment recruitment;
	
	private String topic;
	
	private String content;
	
	private String time;
	
	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
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
		
		recruitment.setTopic(topic);
		recruitment.setContent(content);
		recruitment.setTime(TimeTools.praseDate(time));
		
		informationManagementService.releaseTheNewsOfRecruitment(recruitment);
		
		return SUCCESS;
	}


}
