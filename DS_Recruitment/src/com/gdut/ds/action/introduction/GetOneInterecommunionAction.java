package com.gdut.ds.action.introduction;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Interecommunion;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.InterecommunionService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetOneInterecommunionAction extends ActionSupport{
	
	private DS_Interecommunion interecommunion;			//返回的结果
	
	private String interecommunionId;			//当前的页数
	
	private InterecommunionService interecommunionService;	//返回结果的service处理接口

	public void setInterecommunion(DS_Interecommunion interecommunion) {
		this.interecommunion = interecommunion;
	}
	
	
	
	

	
	
	public void setInterecommunionId(String interecommunionId) {
		this.interecommunionId = interecommunionId;
	}







	public void setInterecommunionService(InterecommunionService interecommunionService) {
		this.interecommunionService = interecommunionService;
	}
	
	

	@Override
	public String execute() throws Exception {
		
		
		
		Gson gson = new Gson();
		
		interecommunion = interecommunionService.getInterecommunionById(interecommunionId);
		
//		Interecommunion = new DS_Interecommunion();
//		Interecommunion.setLeaderName("abcd");
		
//		Interecommunion.setImages(null);
//		System.out.println(gson.toJson(Interecommunion));
		
		if(null!=interecommunion)
		if(null!=interecommunion.getImages())
		for(Image image:interecommunion.getImages()){
			image.setInterecommunion(null);
		}
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		resp.getWriter().write(gson.toJson(interecommunion));
		resp.getWriter().flush();
		resp.getWriter().close();
		//System.out.println(Interecommunion.getDescription());
		
		return SUCCESS;
	}

}
