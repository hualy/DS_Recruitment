package com.gdut.ds.service;

import java.util.List;
import java.util.Set;

import com.gdut.ds.beans.introduction.DS_Article;
import com.gdut.ds.beans.introduction.Image;

public interface ArticleService {
	
	
	
	//创造推送的接口
	public void createArticle(String theme, String date, String lanucher, String description, String content,String xheSavePath );
	
	//得到推送接口
	public List<DS_Article> getArticle(int currentPackage);
	
	//得到推送接口
	public DS_Article getArticleDetail(int currentPage);
	//根据id更新接口
	public void updateArticle(String id,String theme, String date, String lanucher, String description, String content,String xheSavePath,String savePath) ;
	
	//根据id删除接口
	public void deleteArticle(String articleId);
	
	//根据id得到某个接口
	public DS_Article getArticleById(String id);
	
	//得到总数
	public Long getCountAll();
	
	public void deleteTempImage();
}
