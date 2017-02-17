package com.gdut.ds.action.user.introduction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.introduction.DS_Result;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ResultService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetResultAction extends ActionSupport{
	
	
	
	private int currentPage;			//当前的页数
	
	private ResultService resultService;	//返回结果的service处理接口
	
	private int type;
	
	private Gson gson;
	@JSON(serialize=false)
	public Gson getGson() {
		return gson;
	}



	public void setGson(Gson gson) {
		this.gson = gson;
	}



	
	
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	
	
	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}
	
	
	

	public void setType(int type) {
		this.type = type;
	}



	@Override
	public String execute() throws Exception {
		
//		System.out.println("currentPage:"+currentPage);
		
		
		DS_Result result = resultService.getResultDetail(currentPage,type);
		List l = new ArrayList();
		
		Long countAll = resultService.getCountByType(type);
		
//		result = new DS_Result();
//		result.setLeaderName("abcd");
		
//		result.setImages(null);
//		System.out.println(gson.toJson(result));
		
		//System.out.println(result.getImages().size());
		if(null!=result) 
			if(null!=result.getImages())
				for(Image image:result.getImages()){
					image.setResult(null);
				}
		
		l.add(result);
		l.add(countAll);
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		resp.getWriter().write(gson.toJson(l));
		resp.getWriter().flush();
		resp.getWriter().close();
		
		return SUCCESS;
	}

}
