package com.gdut.ds.action.user.introduction;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Member;
import com.gdut.ds.service.MemberService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetMemberAction extends ActionSupport{
	
	private List<DS_Member> members;			//返回的结果
	
	
	private int majorOnDs;					//查看的方向
	
	private MemberService memberService;	//返回结果的service处理接口
	private Gson gson;
	
	
	public void setMembers(List<DS_Member> members) {
		this.members = members;
	}


	

	



	public void setMajorOnDs(int majorOnDs) {
		this.majorOnDs = majorOnDs;
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
		
	
		
		members = memberService.getMemberDetail(majorOnDs);
		
//		Member = new DS_Member();
//		Member.setLeaderName("abcd");
		
//		Member.setImages(null);
//		System.out.println(gson.toJson(Member));
		
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		resp.getWriter().write(gson.toJson(members));
		resp.getWriter().flush();
		resp.getWriter().close();
		//System.out.println(Member.getDescription());
		
		return SUCCESS;
	}

}
