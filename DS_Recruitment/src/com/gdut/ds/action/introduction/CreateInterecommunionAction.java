package com.gdut.ds.action.introduction;

import java.io.File;
import java.util.List;
import java.util.Set;


import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.InterecommunionService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CreateInterecommunionAction extends ActionSupport {
	
	
    private String theme;			//主题
    private String date;				//日期
    private String speaker;		//主讲人
    private String presenter; 	//主持人
    private String content;		//内容，有图片的用<image>代替
    private String savePath;		//文件保存的主路径，在struts2的参数设置
   
    private String message;			//返回给前端的一些信息
    
    private List<File> files;					//struts2传来的文件
    private List<String> filesFileName;			//struts2传来的文件名
    private List<String> filesContentType;		//struts2传来的文件类型
   
    private ImageFunction imageFunction;  //文件处理类，由spring注入
    
    private InterecommunionService interecommunionService;	//service层处理创建的Interecommunion
    
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getPresenter() {
		return presenter;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<String> getFilesFileName() {
		return filesFileName;
	}
	public void setFilesFileName(List<String> filesFileName) {
		this.filesFileName = filesFileName;
	}
	public List<String> getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(List<String> filesContentType) {
		this.filesContentType = filesContentType;
	}

	public ImageFunction getImageFunction() {
		return imageFunction;
	}

	public void setImageFunction(ImageFunction imageFunction) {
		this.imageFunction = imageFunction;
	}

	public InterecommunionService getInterecommunionService() {
		return interecommunionService;
	}

	public void setInterecommunionService(
			InterecommunionService interecommunionService) {
		this.interecommunionService = interecommunionService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		if(speaker==null||"".equals(speaker.trim())){
			message="主讲人不能为空";
			return INPUT;
		}
		
		Set<Image> images = imageFunction.deal(files, filesContentType,		//储存图片的路径信息和支持储存图片 
				Image.TYPE_INTERECOMMUNION, savePath,RealPathUtil.getRealPath());
		
		//description = "第一张图片<image/>;第二张图片<image/>;第三张图片<image/>;第四张图片<image/>;第五张图片<image/>;第六张图片<image/>;第七张图片<image/>;"; 
		
		
		
		interecommunionService.createInterecommunion(theme, date, speaker, presenter, content, images);
		
		message="创建交流会成功";
		
		return SUCCESS;
	}
	
}








