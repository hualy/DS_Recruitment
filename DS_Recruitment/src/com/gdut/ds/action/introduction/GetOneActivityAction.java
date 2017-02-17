package com.gdut.ds.action.introduction;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Activity;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ActivityService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetOneActivityAction extends ActionSupport{
	
	private DS_Activity activity;			//返回的结果
	
	private String  activityId;			//id
	
	private ActivityService activityService;	//返回结果的service处理接口
	
	private Gson gson;

	public void setActivity(DS_Activity activity) {
		this.activity = activity;
	}
	
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}






	public void setGson(Gson gson) {
		this.gson = gson;
	}






	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	

	@Override
	public String execute() throws Exception {
		
		
		
		
		
		activity = activityService.getActivityById(activityId);
		
//		Activity = new DS_Activity();
//		Activity.setLeaderName("abcd");
		
		//activity.setImages(null);
//		System.out.println(gson.toJson(Activity));
		
		for(Image image:activity.getImages()){
			image.setActivity(null);
		}
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		resp.getWriter().write(gson.toJson(activity));
		resp.getWriter().flush();
		resp.getWriter().close();
		
		return SUCCESS;
	}

}
