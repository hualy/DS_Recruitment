package com.gdut.ds.action.examination.manager;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.examination.InformationForExam;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.gdut.ds.utils.TimeTools;
import com.opensymphony.xwork2.ActionSupport;

public class ReviseInformationForExamAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	
	private String id;
	
	private String examName;
	
	private String setID;

	private String beginTime;
	
	private String endTime;
	
	private String wholeTime;
	
	private InformationForExam informationForExam;
	
	private ExaminationServiceImpl examinationService;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getSetID() {
		return setID;
	}

	public void setSetID(String setID) {
		this.setID = setID;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getWholeTime() {
		return wholeTime;
	}

	public void setWholeTime(String wholeTime) {
		this.wholeTime = wholeTime;
	}

	@JSON(serialize=false)
	public InformationForExam getInformationForExam() {
		return informationForExam;
	}

	public void setInformationForExam(InformationForExam informationForExam) {
		this.informationForExam = informationForExam;
	}

	@JSON(serialize=false)
	public ExaminationServiceImpl getExaminationService() {
		return examinationService;
	}

	public void setExaminationService(ExaminationServiceImpl examinationService) {
		this.examinationService = examinationService;
	}
	
	
	@Override
	public String execute() throws Exception {
	
		String result = "success";
		
		informationForExam.setId(Integer.parseInt(id));
		informationForExam.setExamName(examName);
		informationForExam.setSetID(Integer.parseInt(setID));
		informationForExam.setBeginTime(TimeTools.praseDate(beginTime));
		informationForExam.setEndTime(TimeTools.praseDate(endTime));
		informationForExam.setWholeTime(wholeTime);
		informationForExam.setFinished(0);
		informationForExam.setReleased(0);
		
		examinationService.modifyTheInformationForExam(informationForExam);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter pw = response.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		
		return SUCCESS;
	}
	
}
