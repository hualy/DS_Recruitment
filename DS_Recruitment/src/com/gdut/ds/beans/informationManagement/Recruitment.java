package com.gdut.ds.beans.informationManagement;

import java.util.Date;

public class Recruitment implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;							//招新信息id号
	
	private String topic;					//招新信息主题
	
	private String content;					//招新内容
	
	private Date time;						//招新信息发布时间

	
	public Recruitment(){
		
	}
	
	
	
	public Recruitment(String topic, String content, Date time) {
		
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
