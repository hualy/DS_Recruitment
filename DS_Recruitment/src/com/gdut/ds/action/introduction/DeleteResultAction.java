package com.gdut.ds.action.introduction;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.service.ResultService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteResultAction extends ActionSupport {
	
	private String resultId;
	private ResultService resultService;

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	
	public ResultService getResultService() {
		return resultService;
	}

	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}
	
	
	
	
	@Override
	public String execute() throws Exception {
		
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
		if(resultId==null) return INPUT;
		
		
		resultService.deleteResult(resultId);
//		HttpServletResponse resp = ServletActionContext.getResponse();
//		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
//		resp.setHeader("pragma", "no-cache");
//		resp.setHeader("cache-control","no-cache");
		
		return SUCCESS;
	}
	
	
}
