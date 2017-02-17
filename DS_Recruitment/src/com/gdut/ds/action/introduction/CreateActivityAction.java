package com.gdut.ds.action.introduction;

import java.io.File;
import java.util.List;
import java.util.Set;


import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ActivityService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CreateActivityAction extends ActionSupport {
	
	
    private String theme;			//主题
    private String date;			//日期
    private String origanzier;		//组织者
    private String content;        //活动内容
    private String thoughts;		//活动感想
    private String savePath;
    
    private String message;			//返回给前端的一些信息
    
    private List<File> files;					//struts2传来的文件
    private List<String> filesFileName;			//struts2传来的文件名
    private List<String> filesContentType;		//struts2传来的文件类型
   
    private ImageFunction imageFunction;  //文件处理类，由spring注入
    
    private ActivityService activityService;
    
	
	
	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void setOriganzier(String origanzier) {
		this.origanzier = origanzier;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public ActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}

	

	public String getTheme() {
		return theme;
	}

	public String getDate() {
		return date;
	}

	public String getOriganzier() {
		return origanzier;
	}

	public String getContent() {
		return content;
	}

	public String getThoughts() {
		return thoughts;
	}

	public String getSavePath() {
		return savePath;
	}

	public List<File> getFiles() {
		return files;
	}

	public List<String> getFilesFileName() {
		return filesFileName;
	}

	public List<String> getFilesContentType() {
		return filesContentType;
	}

	public ImageFunction getImageFunction() {
		return imageFunction;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public void setFilesFileName(List<String> filesFileName) {
		this.filesFileName = filesFileName;
	}

	public void setFilesContentType(List<String> filesContentType) {
		this.filesContentType = filesContentType;
	}

	public void setImageFunction(ImageFunction imageFunction) {
		this.imageFunction = imageFunction;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

	@Override
	public String execute() throws Exception {
		
//		System.out.println("content=="+content+"==");
//		System.out.println("content trim =="+content.trim()+"==");
		
//		System.out.println("RealPath"+RealPathUtil.getRealPath());
		
		if(content==null||content.trim().equals("")){
			message="活动内容不能为空  请重新输入 ";
			return INPUT;
		}
		if(theme==null||theme.trim().equals("")){
			message="活动主题不能为空  请重新输入 ";
			return INPUT;
		}
		if(null==date||date.trim().equals("")){
			message="日期不能为空   请重新输入 ";
			return INPUT;
		}
		if(null==thoughts||thoughts.trim().equals("")){
			message="活动感想不能为空   请重新输入";
			return INPUT;
		}
		if(null==origanzier||origanzier.trim().equals("")){
			message="组织都不能为空   请重新输入 ";
			return INPUT;
		}
		
			
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
//		
		Set<Image> images = imageFunction.deal(files, filesContentType,		//储存图片的路径信息和支持储存图片 
				Image.TYPE_ACTIVITY, savePath,RealPathUtil.getRealPath());
		
		//description = "第一张图片<image/>;第二张图片<image/>;第三张图片<image/>;第四张图片<image/>;第五张图片<image/>;第六张图片<image/>;第七张图片<image/>;"; 
		
		
		activityService.createActivity(theme, date, origanzier, content, thoughts, images);
		
		message="创建成功";
		
		//ServletActionContext.getRequest().setAttribute("message", message);
		
		return SUCCESS;
	}
	
}








