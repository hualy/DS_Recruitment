package com.gdut.ds.beans.introduction;
// Generated 2016-1-29 16:03:55 by Hibernate Tools 3.3.0.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 文章推送
 */
public class DS_Article  implements java.io.Serializable {


     

	private String id;				//id
     private String theme;			//主题
     private String date;				//日期
     private String lanucher;		//发布者
     private String description;	//描述
     private String content;		//内容，有图片的用<image>代替
     //private Set<Image> images = new HashSet<Image>(0);  //图片

    public DS_Article() {
    }
    public DS_Article(String id, String theme, String date, String lanucher) {
		super();
		this.id = id;
		this.theme = theme;
		this.date = date;
		this.lanucher = lanucher;
	}
    public DS_Article(String id,String theme, String date, String lanucher, String description, String content) {
       this.theme = theme;
       this.date = date;
       this.lanucher = lanucher;
       this.description = description;
       this.content = content;
       //this.images = images;
       this.id = id;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getTheme() {
        return this.theme;
    }
    
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    public String getLanucher() {
        return this.lanucher;
    }
    
    public void setLanucher(String lanucher) {
        this.lanucher = lanucher;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
   



}


