package com.gdut.ds.service;

import java.util.List;
import java.util.Set;

import com.gdut.ds.beans.introduction.DS_Activity;
import com.gdut.ds.beans.introduction.Image;

public interface ActivityService {
	
	
	
	//创造活动的接口
	public void createActivity(String theme,String date,String origanzier,String content,String thoughts,Set<Image> images);
	
	//得到活动接口
	public List<DS_Activity> getActivity(int currentPage);
	
	//得到活动接口
	public DS_Activity getActivitiesDetail(int currentPage);
	
	//根据id更新接口
	public void updateActivity(String id,String theme,String date,String origanzier,String content,String thoughts,boolean resetPicture,Set<Image> images) ;
	
	//根据id删除接口
	public void deleteActivity(String Id);
	
	//根据id得到某个接口
	public DS_Activity getActivityById(String id);
	
	//得到总数
	public Long getCountAll();
	
}
