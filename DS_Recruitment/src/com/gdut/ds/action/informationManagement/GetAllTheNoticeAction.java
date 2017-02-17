package com.gdut.ds.action.informationManagement;

import java.util.List;
import java.util.Map;

import com.gdut.ds.beans.informationManagement.Notice;
import com.gdut.ds.serviceImpl.InformationManagementServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllTheNoticeAction extends ActionSupport {

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
		
		Map<String, Object> request = ActionContext.getContext().getContextMap();
		
		List<Notice> noticeList = informationManagementService.getNotices();
		
		request.put("notices", noticeList);
		
		return SUCCESS;
	}
}
