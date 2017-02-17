package com.gdut.ds.action.informationManagement;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.informationManagement.Recruitment;
import com.gdut.ds.serviceImpl.InformationManagementServiceImpl;
import com.gdut.ds.utils.TimeTools;
import com.opensymphony.xwork2.ActionSupport;

public class ReviseTheRecruitmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private InformationManagementServiceImpl informationManagementService;
	
	private String topic;
	
	private String content;
	
	private String time;
	
	private Recruitment recruitment;
	
	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JSON(serialize=false)
	public InformationManagementServiceImpl getInformationManagementService() {
		return informationManagementService;
	}

	public void setInformationManagementService(
			InformationManagementServiceImpl informationManagementService) {
		this.informationManagementService = informationManagementService;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

	public String execute() throws Exception {
		
		recruitment.setId(Integer.parseInt(id));
		recruitment.setTopic(topic);
		recruitment.setContent(content);
		recruitment.setTime(TimeTools.praseDate(time));
		
		informationManagementService.modifyTheNewsOfRecruitment(recruitment);
		
		String json = "success";
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");		//设置类型为json
		response.setHeader("Cache-Control","no-cache");

		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.flush();
		pw.close();
		
		return SUCCESS;
	}
}
