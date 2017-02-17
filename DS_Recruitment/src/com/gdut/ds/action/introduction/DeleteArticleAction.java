package com.gdut.ds.action.introduction;


import com.gdut.ds.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteArticleAction extends ActionSupport {
	
	private String articleId;
	private ArticleService articleService;

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
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
		
		if(articleId==null) return INPUT;
		
		articleService.deleteArticle(articleId);
		
		return SUCCESS;
	}
	
	
}
