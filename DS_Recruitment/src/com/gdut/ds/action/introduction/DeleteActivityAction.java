package com.gdut.ds.action.introduction;


import com.gdut.ds.service.ActivityService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteActivityAction extends ActionSupport {
	
	private String activityId;
	private ActivityService activityService;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
	public ActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	
	
	
	@Override
	public String execute() throws Exception {
		
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
		
		if(activityId==null) return INPUT;
		
		activityService.deleteActivity(activityId);
		
		return SUCCESS;
	}
	
	
}
