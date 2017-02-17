package com.gdut.ds.beans.introduction;

import java.util.HashSet;
import java.util.Set;

public class DS_Interecommunion {
	private String id;				//id
    private String theme;			//主题
    private String date;				//日期
    private String speaker;		//主讲人
    private String presenter; 	//主持人
    private String content;		//内容，有图片的用<image>代替
    private Set<Image> images = new HashSet<Image>(0);  //图片
    
    public DS_Interecommunion() {
    }

    public DS_Interecommunion(String theme, String date, String speaker,String presenter,  String content, Set<Image> images) {
       this.theme = theme;
       this.date = date;
       this.speaker = speaker;
       this.presenter = presenter;
       this.content = content;
       this.images = images;
    }
    
    
    
	public DS_Interecommunion(String id, String theme, String date,
			String speaker) {
		super();
		this.id = id;
		this.theme = theme;
		this.date = date;
		this.speaker = speaker;
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
	public Set<Image> getImages() {
		return images;
	}
	public void setImages(Set<Image> images) {
		this.images = images;
	}
    
    
}
