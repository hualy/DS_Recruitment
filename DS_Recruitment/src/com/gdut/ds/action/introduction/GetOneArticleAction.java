package com.gdut.ds.action.introduction;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Article;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ArticleService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetOneArticleAction extends ActionSupport{
	
	private DS_Article article;			//返回的结果
	
	private String articleId;			//当前的页数
	
	private Gson gson;
	
	private ArticleService articleService;	//返回结果的service处理接口

	public void setArticle(DS_Article article) {
		this.article = article;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	
	
	public void setGson(Gson gson) {
		this.gson = gson;
	}

	@Override
	public String execute() throws Exception {
		
//		System.out.println("currentPage:"+currentPage);
		
		
		article = articleService.getArticleById(articleId);
		
//		Article = new DS_Article();
//		Article.setLeaderName("abcd");
		
//		Article.setImages(null);
//		System.out.println(gson.toJson(Article));
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		resp.getWriter().write(gson.toJson(article));
		resp.getWriter().flush();
		resp.getWriter().close();
		//System.out.println(Article.getDescription());
		
		return SUCCESS;
	}

}
