package com.gdut.ds.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gdut.ds.beans.introduction.DS_Activity;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.dao.introduction.ImageDao;
import com.gdut.ds.dao.introduction.ActivityDao;
import com.gdut.ds.service.ActivityService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;

public class ActivityServiceImpl implements ActivityService {
	
	private static final int admPageSize = 10;   //设置查看结果页面的页数为10
	
	private static final int pageSize = 1;		//成员设置查看页数为1
	
	private ActivityDao activityDao;
	
	private DS_Activity activity;
	
	private ImageFunction imageFunction;
	
	private ImageDao imageDao;
	
	public ActivityDao getActivityDao() {
		return activityDao;
	}


	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	

	
	public DS_Activity getActivity() {
		return activity;
	}


	public void setActivity(DS_Activity Activity) {
		this.activity = Activity;
	}


	public ImageFunction getImageFunction() {
		return imageFunction;
	}


	public void setImageFunction(ImageFunction imageFunction) {
		this.imageFunction = imageFunction;
	}


	public ImageDao getImageDao() {
		return imageDao;
	}


	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}


	//更新
	
	
	//查找
	public List<DS_Activity> getActivity(int currentPage) {
		
		return activityDao.findByPage("select new DS_Activity(id,theme,date,origanzier) from DS_Activity ", (currentPage-1)*admPageSize, admPageSize);
	}
	

	
	//根据id来删除接口
	public void deleteActivity(String ActivityId) {
		
		activity = activityDao.get(DS_Activity.class, ActivityId);
		
		Set<Image> images = activity.getImages();	//得到图片
		
//		System.out.println(images.size());
//		
//		for(Image image:images){
//			System.out.println(image.getPath());
//		}
		
		imageFunction.deleteImage(images,RealPathUtil.getRealPath());		//删除图片
		
		for(Image image:images){
			imageDao.delete(image);				//从数据库中删除与图片有关的信息
		}
		
		activityDao.delete(activity);				//从数据库中删除Activity相关信息
		
	}


	public void createActivity(String theme, String date, String origanzier,
			String content, String thoughts, Set<Image> images) {
		activity.setDate(date);
		activity.setContent(content);
		activity.setImages(images);
		activity.setOriganzier(origanzier);
		activity.setTheme(theme);
		activity.setThoughts(thoughts);
		activityDao.save(activity);
		
	}


	public void updateActivity(String id, String theme, String date,
			String origanzier, String content, String thoughts,boolean resetPicture,
			Set<Image> images) {
			DS_Activity activity = activityDao.get(DS_Activity.class, id);		//得到Activity实体
		
			activity.setDate(date);
			activity.setContent(content);
			if(resetPicture){
				
				Set<Image> activityImages = activity.getImages(); //删除在数据库的图片
				
				activity.setImages(null);
				
				imageFunction.deleteImage(activityImages,RealPathUtil.getRealPath());		//删除图片
				
				for(Image image:activityImages){
					imageDao.delete(image);				//从数据库中删除与图片有关的信息
				}
				
				
				if(null==activity.getImages()) activity.setImages(new HashSet<Image>());
				for(Image image:images){
					activity.getImages().add(image);
				}
			}
			
			activity.setOriganzier(origanzier);
			activity.setTheme(theme);
			activity.setThoughts(thoughts);
			activityDao.update(activity);
		
	}


	public Long getCountAll() {
		
		return activityDao.findCount(DS_Activity.class);
	}


	public DS_Activity getActivityById(String id) {
		
		return activityDao.get(DS_Activity.class, id);
	}


	public DS_Activity getActivitiesDetail(int currentPage) {
		
		List<DS_Activity> l =activityDao.findByPage("from DS_Activity ", (currentPage-1)*pageSize, pageSize);
		if(l==null||l.size()<=0) return null;
		return l.get(0);
	}
	
	


	
}
