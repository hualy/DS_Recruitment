package com.gdut.ds.action.introduction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Member;
import com.gdut.ds.service.MemberService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetMemberAction extends ActionSupport{
	
	private List<DS_Member> members;			//返回的结果
	
	private int currentPage;			//当前的页数
	
	
	
	private MemberService memberService;	//返回结果的service处理接口

	private Gson gson;
	
	
	public void setMembers(List<DS_Member> members) {
		this.members = members;
	}




	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}




	


	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}





	public void setGson(Gson gson) {
		this.gson = gson;
	}




	@Override
	public String execute() throws Exception {
		
//		System.out.println("currentPage:"+currentPage);
		
		
		
		members = memberService.getMember(currentPage);
		
//		Member = new DS_Member();
//		Member.setLeaderName("abcd");
		
//		Member.setImages(null);
//		System.out.println(gson.toJson(Member));
	
		Long countAll = memberService.getCountAll();
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		List l = new ArrayList(2);
		
		l.add(members);
		l.add(countAll);
		
		resp.getWriter().write(gson.toJson(l));
		resp.getWriter().flush();
		resp.getWriter().close();
		//System.out.println(Member.getDescription());
		
		return SUCCESS;
	}

}
