package com.gdut.ds.action.introduction;

import java.io.File;
import java.util.List;
import java.util.Set;


import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.InterecommunionService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateInterecommunionAction extends ActionSupport {
		private String interecommunionId;
		
		 private String theme;			//主题
		 private String date;				//日期
		 private String speaker;		//主讲人
		 private String presenter; 	//主持人
		 private String content;		//内容，有图片的用<image>代替
		 private String savePath;		//文件保存的主路径，在struts2的参数设置
		    
		private List<File> files;					//struts2传来的文件
	    private List<String> filesFileName;			//struts2传来的文件名
	    private List<String> filesContentType;		//struts2传来的文件类型
	    
	    private ImageFunction imageFunction;  //文件处理类，由spring注入
	    
	    private InterecommunionService interecommunionService;		//更新处理的service类

	    private String message;			//返回给前端的一些信息
	    private boolean resetPicture;	//是否重新放置图片

	    


		public String getInterecommunionId() {
			return interecommunionId;
		}



		public void setInterecommunionId(String interecommunionId) {
			this.interecommunionId = interecommunionId;
		}



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



		public boolean isResetPicture() {
			return resetPicture;
		}



		public void setResetPicture(boolean resetPicture) {
			this.resetPicture = resetPicture;
		}



	@Override
    	public String execute() throws Exception {
		
		if(theme==null||"".equals(theme.trim())){
			message="主题不能为空";
			return INPUT;
		}
		if(date==null||"".equals(date.trim())){
			message="日期不能为空";
			return INPUT;
		}
		
		if(speaker==null||"".equals(speaker.trim())){
			message = "主讲人不能为空";
			return INPUT;
		}
		if(interecommunionId==null){
			message="请输入合法的数据";
			return INPUT;
		}
		if(content==null||"".equals(content.trim())){
			message="请输入交流会的内容";
			return INPUT;
		}
		
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
		Set<Image> images = null;
		if(resetPicture){
			images  =  imageFunction.deal(files, filesContentType, 
	    			Image.TYPE_INTERECOMMUNION, savePath,RealPathUtil.getRealPath());
		}
		
    	
    	interecommunionService.updateInterecommunion(interecommunionId, theme, date, speaker, presenter, content,resetPicture, images);
    	message="更新成功";
    	return SUCCESS;
    }
	
}
