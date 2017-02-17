package com.gdut.ds.action.introduction;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Member;
import com.gdut.ds.service.MemberService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetOneMemberAction extends ActionSupport{
	
	private DS_Member member;			//返回的结果
	
	private String memberId;			

	private MemberService memberService;	//返回结果的service处理接口

	
	private Gson gson;


	public void setMember(DS_Member member) {
		this.member = member;
	}





	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}





	public void setGson(Gson gson) {
		this.gson = gson;
	}





	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}





	@Override
	public String execute() throws Exception {
		
//		System.out.println("currentPage:"+currentPage);
		
	
		
		member = memberService.getMemberById(memberId);
		
//		Member = new DS_Member();
//		Member.setLeaderName("abcd");
		
//		Member.setImages(null);
//		System.out.println(gson.toJson(Member));
		
		
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		resp.getWriter().write(gson.toJson(member));
		resp.getWriter().flush();
		resp.getWriter().close();
		//System.out.println(Member.getDescription());
		
		return SUCCESS;
	}

}
