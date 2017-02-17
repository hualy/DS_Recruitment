package com.gdut.ds.action.user.introduction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Interecommunion;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.InterecommunionService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetInterecommunionAction extends ActionSupport{
	
	private DS_Interecommunion interecommunion;			//返回的结果
	
	private int currentPage;			//当前的页数
	
	private Gson gson;
	
	private InterecommunionService interecommunionService;	//返回结果的service处理接口

	public void setInterecommunion(DS_Interecommunion interecommunion) {
		this.interecommunion = interecommunion;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setInterecommunionService(InterecommunionService interecommunionService) {
		this.interecommunionService = interecommunionService;
	}
	
	public void setGson(Gson gson) {
		this.gson = gson;
	}

	@Override
	public String execute() throws Exception {
		
//		System.out.println("currentPage:"+currentPage);
		
		
		
		interecommunion = interecommunionService.getInterecommunionDetail(currentPage);
		
//		Interecommunion = new DS_Interecommunion();
//		Interecommunion.setLeaderName("abcd");
		
//		Interecommunion.setImages(null);
//		System.out.println(gson.toJson(Interecommunion));
		
		if(null!=interecommunion)
			for(Image image:interecommunion.getImages()){
				image.setInterecommunion(null);
			}
		
		Long countAll = interecommunionService.getCountAll();
		
		List l = new ArrayList(2);
		
		l.add(interecommunion);
		l.add(countAll);
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		resp.getWriter().write(gson.toJson(l));
		resp.getWriter().flush();
		resp.getWriter().close();
		//System.out.println(Interecommunion.getDescription());
		
		return SUCCESS;
	}

}
