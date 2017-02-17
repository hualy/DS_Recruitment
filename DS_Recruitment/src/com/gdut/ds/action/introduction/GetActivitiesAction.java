package com.gdut.ds.action.introduction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Activity;
import com.gdut.ds.service.ActivityService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetActivitiesAction extends ActionSupport{
	
	private List<DS_Activity> activities;			//返回的结果
	
	private Gson gson;
	
	private int currentPage;			//当前的页数
	
	private ActivityService activityService;	//返回结果的service处理接口

	
	
	
	public void setGson(Gson gson) {
		this.gson = gson;
	}



	public void setActivities(List<DS_Activity> activities) {
		this.activities = activities;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	
	
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	

	@Override
	public String execute() throws Exception {
				
		activities = activityService.getActivity(currentPage);
		
//		Activity = new DS_Activity();
//		Activity.setLeaderName("abcd");
		
		//activity.setImages(null);
//		System.out.println(gson.toJson(Activity));
		
//		for(Image image:activity.getImages()){
//			image.setResult(null);
//		}
		
		List l = new ArrayList();
		l.add(activities);
		
		Long countAll = activityService.getCountAll();
		l.add(countAll);
		
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		resp.getWriter().write(gson.toJson(l));
		resp.getWriter().flush();
		resp.getWriter().close();
		//System.out.println(Activity.getDescription());
		
		return SUCCESS;
	}

}
