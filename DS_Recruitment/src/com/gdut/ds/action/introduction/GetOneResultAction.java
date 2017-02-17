package com.gdut.ds.action.introduction;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.introduction.DS_Result;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ResultService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetOneResultAction extends ActionSupport{
	
	private DS_Result result;			//返回的结果
	
	private String resultId;			
	
	private ResultService resultService;	//返回结果的service处理接口
	
	private Gson gson;
	@JSON(serialize=false)
	public Gson getGson() {
		return gson;
	}



	public void setGson(Gson gson) {
		this.gson = gson;
	}



	public void setResult(DS_Result result) {
		this.result = result;
	}
	
	

	
	
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}



	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}
	
	

	@Override
	public String execute() throws Exception {
		
//		System.out.println("currentPage:"+currentPage);
		
		
		result = resultService.getResultById(resultId);
		
//		result = new DS_Result();
//		result.setLeaderName("abcd");
		
//		result.setImages(null);
//		System.out.println(gson.toJson(result));
		
		for(Image image:result.getImages()){
			image.setResult(null);
		}
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		resp.getWriter().write(gson.toJson(result));
		resp.getWriter().flush();
		resp.getWriter().close();
		//System.out.println(result.getDescription());
		
		return SUCCESS;
	}

}
