package com.gdut.ds.action.user.introduction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Article;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ArticleService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetArticleAction extends ActionSupport{
	
	private DS_Article article;			//返回的结果
	
	private int currentPage;			//当前的页数
	
	private Gson gson;
	
	public void setArticle(DS_Article article) {
		this.article = article;
	}



	public void setGson(Gson gson) {
		this.gson = gson;
	}



	private ArticleService articleService;	//返回结果的service处理接口

	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	

	@Override
	public String execute() throws Exception {
		
//		System.out.println("currentPage:"+currentPage);
		
		
		article = articleService.getArticleDetail(currentPage);
		
//		Article = new DS_Article();
//		Article.setLeaderName("abcd");
		
//		Article.setImages(null);
//		System.out.println(gson.toJson(Article));
		
		Long countAll = articleService.getCountAll();
		
		List l = new ArrayList(2);
		l.add(article);
		l.add(countAll);
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		resp.getWriter().write(gson.toJson(l));
		resp.getWriter().flush();
		resp.getWriter().close();
		//System.out.println(Article.getDescription());
		
		return SUCCESS;
	}

}
