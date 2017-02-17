package com.gdut.ds.beans.informationManagement;

import java.util.Date;

public class PageViews {

	private int id;						//浏览量id
	
	private int totality;					//浏览量总数

	private Date closeTime;				//服务器关闭时的时间
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	
	public void setTotality(int totality) {
		this.totality = totality;
	}

	public int getTotality() {
		return totality;
	}

	public PageViews(){
		
	}

	public PageViews(int totality, Date closeTime) {
		
		this.totality = totality;
		this.closeTime = closeTime;
	}
	
	
	
}
