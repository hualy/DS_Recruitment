package com.gdut.ds.action.introduction;

import java.io.File;
import java.util.List;
import java.util.Set;


import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ActivityService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateActivityAction extends ActionSupport {
	
	private String activityId;				//id
    private String theme;			//主题
    private String date;			//日期
    private String origanzier;		//组织者
    private String content;        //活动内容
    private String thoughts;		//活动感想
    private String savePath;
    
    private boolean resetPicture;		//是否更新图片
    
    private String message;			//信息
    
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

	public boolean isResetPicture() {
		return resetPicture;
	}

	public void setResetPicture(boolean resetPicture) {
		this.resetPicture = resetPicture;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	@Override
    public String execute() throws Exception {
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
		
		if(theme==null||"".equals(theme.trim())){
			message="主题不能为空";
			return INPUT;
		}
		if(date==null||"".equals(date.trim())){
			message="日期不能为空";
			return INPUT;
		}
		if(activityId==null){
			message="请输入合法数据";
			return INPUT;
		}
		if(origanzier==null||"".equals(origanzier.trim())){
			message="组织者不能为空";
			return INPUT;
		}
		if(content==null||"".equals(content.trim())){
			message="内容不能为空";
			return INPUT;
		}
		if(thoughts==null||"".equals(thoughts.trim())){
			message="想法不能为空";
			return INPUT;
		}
		Set<Image> images = null;
		if(resetPicture){
			images =  imageFunction.deal(files, filesContentType, 
		    			Image.TYPE_ACTIVITY, savePath,RealPathUtil.getRealPath());
		}
		 
		if(activityId==null){
			message="内容不合法";
			return INPUT;
		}
    	
    	activityService.updateActivity(activityId, theme, date, origanzier, content, thoughts,resetPicture, images);
    	
    	message="更新成功";
    	
    	return SUCCESS;
    }
	
}
