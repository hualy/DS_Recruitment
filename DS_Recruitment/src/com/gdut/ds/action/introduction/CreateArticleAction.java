package com.gdut.ds.action.introduction;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Set;


import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ArticleService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CreateArticleAction extends ActionSupport {
	
	 
     private String theme;			//主题
     private String date;				//日期
     private String lanucher;		//发布者
     private String description;	//描述
     private String content;		//内容，有图片的用<image>代替
     
     private String savePath;		//由struts2传入的保存路径
     
     private String xheSavePath ;  //在xhesavePath的保存的图片路径，进行转移
    
   
    private ImageFunction imageFunction;  //文件处理类，由spring注入
    
    private ArticleService articleService;	//service层处理创建的Article
   
    private String message;	  //返回给前端的一些信息	
	
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLanucher() {
		return lanucher;
	}

	public void setLanucher(String lanucher) {
		this.lanucher = lanucher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

	

	

	public ImageFunction getImageFunction() {
		return imageFunction;
	}

	public void setImageFunction(ImageFunction imageFunction) {
		this.imageFunction = imageFunction;
	}

	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	public String getXheSavePath() {
		return xheSavePath;
	}

	public void setXheSavePath(String xheSavePath) {
		this.xheSavePath = xheSavePath;
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
		if(lanucher==null||"".equals(lanucher.trim())){
			message="发布者姓名不能为空";
			return INPUT;
		}
		if(content==null||"".equals(content.trim())){
			message="内容姓名不能为空";
			return INPUT;
		}
		
		
		articleService.createArticle(theme, date, lanucher, description, content,xheSavePath);
		
		message="推送发布成功";
		
		return SUCCESS;
	}
	
}








