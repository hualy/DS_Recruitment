package com.gdut.ds.beans.introduction;


import java.util.HashSet;
import java.util.Set;

/**
 * 工作室日常活动
 */
public class DS_Activity  implements java.io.Serializable {


     private String id;				//id
     private String theme;			//主题
     private String date;			//日期
     private String origanzier;		//组织者
     private String content;        //活动内容
     private String thoughts;		//活动感想
     
     private Set<Image> images = new HashSet<Image>(0);	//图片

    public DS_Activity() {
    }
    
    

    public DS_Activity(String id, String theme, String date, String origanzier) {
		this.id = id;
		this.theme = theme;
		this.date = date;
		this.origanzier = origanzier;
	}



	public DS_Activity(String theme, String date, String origanzier,String content,String thoughts, Set<Image> images) {
       this.theme = theme;
       this.date = date;
       this.origanzier = origanzier;
       this.content = content;
       this.thoughts = thoughts;
       this.images = images;
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
    public String getOriganzier() {
        return this.origanzier;
    }
    
    public void setOriganzier(String origanzier) {
        this.origanzier = origanzier;
    }
    public Set<Image> getImages() {
        return this.images;
    }
    
    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public void setImages(Set<Image> images) {
        this.images = images;
    }




}


