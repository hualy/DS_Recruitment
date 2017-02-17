package com.gdut.ds.action.introduction;



import com.gdut.ds.service.ArticleService;
import com.gdut.ds.utils.ImageFunction;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateArticleAction extends ActionSupport {
	
	private String articleId;		//由客户端返回的更新的数据
	
	private String id;				//id
    private String theme;			//主题
    private String date;				//日期
    private String lanucher;		//发布者
    private String description;	//描述
    private String content;		//内容，有图片的用<image>代替
    
    private String savePath;		//由struts2传入的保存路径
    
    private String xheSavePath;		//xheSavePath
    
    private String message;			//传回给后台的一些参数
	    

    private ImageFunction imageFunction;  //文件处理类，由spring注入
    
    private ArticleService articleService;		//更新处理的service类

	

	public String getArticleId() {
		return articleId;
	}



	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	@Override
    public String execute() throws Exception {
		
    	if(articleId==null){
    		message = "请输入合法的数据";
    		return INPUT;
    	}
    	if(theme==null||"".equals(theme.trim())){
    		message = "请输入主题";
    		return INPUT;
    	}
    	if(date==null||"".equals(date.trim())){
    		message="请输入日期";
    		return INPUT;
    	}
    	if(lanucher==null||"".equals(lanucher.trim())){
    		message="请输入发布者姓名";
    		return INPUT;
    	}
    	
		
    	articleService.updateArticle(articleId, theme, date, lanucher, description, content,xheSavePath,savePath);
    	
    	message = "更新成功";
    	
    	return SUCCESS;
    }
	
}
