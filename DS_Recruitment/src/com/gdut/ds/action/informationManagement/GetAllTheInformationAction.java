package com.gdut.ds.action.informationManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gdut.ds.beans.informationManagement.Notice;
import com.gdut.ds.beans.informationManagement.Recruitment;
import com.gdut.ds.serviceImpl.InformationManagementServiceImpl;
import com.gdut.ds.utils.TimeTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllTheInformationAction extends ActionSupport {

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
	
	
	@SuppressWarnings("deprecation")
	public String execute() throws Exception {
		
		List<Notice> noticeList = informationManagementService.getNotices();
		List<Recruitment> recruitmentList = informationManagementService.getRecruitments();
		int maxMonth = 0;
		int minMonth = 0;
		Map<String, Object> groupsInfo = new HashMap<String, Object>();			//记录分组信息
		Map<String, Object> infoMap = new HashMap<String, Object>();
		
		infoMap = TimeTools.mixUpAllTheInformation(noticeList, recruitmentList); //获取排好序的信息Map
		
		if(noticeList.size() != 0 && recruitmentList.size() != 0){
			//记住，Java中的月份是从0开始算起的
			maxMonth = noticeList.get(0).getTime().getMonth() >= recruitmentList.get(0).getTime().getMonth() 
							? noticeList.get(0).getTime().getMonth() + 1 : recruitmentList.get(0).getTime().getMonth() + 1;
							
			minMonth = noticeList.get(noticeList.size() - 1).getTime().getMonth() <=  recruitmentList.get(recruitmentList.size() - 1).getTime().getMonth()
			                ?  noticeList.get(noticeList.size() - 1).getTime().getMonth() + 1 : recruitmentList.get(recruitmentList.size() - 1).getTime().getMonth() + 1;
			
		}else if(noticeList.size() == 0 && recruitmentList.size() != 0){

			//记住，Java中的月份是从0开始算起的
			maxMonth = recruitmentList.get(0).getTime().getMonth() + 1;
							
			minMonth = recruitmentList.get(recruitmentList.size() - 1).getTime().getMonth() + 1;
			
		}else if(noticeList.size() != 0 && recruitmentList.size() == 0){

			//记住，Java中的月份是从0开始算起的
			maxMonth =  noticeList.get(0).getTime().getMonth() + 1;
							
			minMonth =  noticeList.get(noticeList.size() - 1).getTime().getMonth() + 1;
			
		}
		                
		groupsInfo.put("maxMonth", maxMonth);
		groupsInfo.put("minMonth", minMonth);
		
		Map<String, Object> request = ActionContext.getContext().getContextMap();
		request.put("groupsInfo", groupsInfo);
		request.put("infoMap", infoMap);
		
		return SUCCESS;
	}
	
	
	
	
}
