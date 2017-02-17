package com.gdut.ds.action.informationManagement;

import java.util.List;
import java.util.Map;

import com.gdut.ds.beans.informationManagement.Recruitment;
import com.gdut.ds.serviceImpl.InformationManagementServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllTheRecruitmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InformationManagementServiceImpl informationManagementService;

	public void setInformationManagementService(
			InformationManagementServiceImpl informationManagementService) {
		this.informationManagementService = informationManagementService;
	}

	public InformationManagementServiceImpl getInformationManagementService() {
		return informationManagementService;
	}
	
	
	
	public String execute() throws Exception {
		
		List<Recruitment> recruitmentList = informationManagementService.getRecruitments();
		Map<String, Object> request = ActionContext.getContext().getContextMap();
		request.put("recruitments", recruitmentList);
		
		return SUCCESS;
	}
	
}
