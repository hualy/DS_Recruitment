package com.gdut.ds.action.user.introduction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Activity;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ActivityService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetActivitiesAction extends ActionSupport{
	
	private DS_Activity activity;			//返回的结果
	
	private Gson gson;
	
	private int currentPage;			//当前的页数
	
	private ActivityService activityService;	//返回结果的service处理接口

	public void setGson(Gson gson) {
		this.gson = gson;
	}
	public void setActivity(DS_Activity activity) {
		this.activity = activity;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	
	
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	@Override
	public String execute() throws Exception {
				
		activity = activityService.getActivitiesDetail(currentPage);
		
//		Activity = new DS_Activity();
//		Activity.setLeaderName("abcd");
		
		//activity.setImages(null);
//		System.out.println(gson.toJson(Activity));
		
		if(null!=activity)
			for(Image image:activity.getImages()){
				image.setActivity(null);
			}
		
		List l = new ArrayList();
		l.add(activity);
		
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
