package com.gdut.ds.action.introduction;


import com.gdut.ds.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteArticleTempImageAction extends ActionSupport {
	
private ArticleService articleService;

	
	public ArticleService getArticleService() {
	return articleService;
}


public void setArticleService(ArticleService articleService) {
	this.articleService = articleService;
}


	@Override
	public String execute() throws Exception {
		
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
		
		articleService.deleteTempImage();
		
		return SUCCESS;
	}
	
	
}
