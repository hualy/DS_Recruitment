package com.gdut.ds.beans.informationManagement;

import java.util.Date;

public class Notice implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;							//id号
	
	private String topic;					//公告主题
	
	private String content;					//公告内容
	
	private Date time;						//公告发布时间
	

	
	public Notice(){
		
	}
	
	
	public Notice(String topic, String content, Date time) {
		
		this.topic = topic;
		this.content = content;
		this.time = time;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getTopic() {
		return topic;
	}

	
	
	
}
