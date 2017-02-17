package com.gdut.ds.beans.examination;

import java.util.Date;

public class InformationForExam implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;							//考试信息id号
	
	private int setID;						//考试选用的套题号
	
	private String examName;				//考试名称
	
	private Date beginTime;					//考试开始时间
	
	private Date endTime;					//考试结束时间
	
	private String wholeTime;				//考试规定总用时
	
	private int released;					//考试是否发布
	
	private int finished;					//该考试是否完成（1——完成，0-未完成）
	
	
	public InformationForExam(){
		
	}
	

	public InformationForExam(int setID, String examName, Date beginTime,
			Date endTime, String wholeTime, int released, int finished) {
	
		this.setID = setID;
		this.examName = examName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.wholeTime = wholeTime;
		this.setReleased(released);
		this.finished = finished;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getWholeTime() {
		return wholeTime;
	}

	public void setWholeTime(String wholeTime) {
		this.wholeTime = wholeTime;
	}

	public void setFinished(int finished) {
		this.finished = finished;
	}

	public int getFinished() {
		return finished;
	}

	public void setSetID(int setID) {
		this.setID = setID;
	}

	public int getSetID() {
		return setID;
	}


	public void setReleased(int released) {
		this.released = released;
	}


	public int getReleased() {
		return released;
	}	
	
}
