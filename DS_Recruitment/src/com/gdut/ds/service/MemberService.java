package com.gdut.ds.service;

import java.util.List;
import com.gdut.ds.beans.introduction.DS_Member;

public interface MemberService {
	
	
	
	//创造的接口
	public void createMember(String name,boolean female,int majorOnDs,String major,int grade,int cla,String description,String imagePath,String leavingWord,String savePath);
	
	//得到成接口
	public List< DS_Member> getMemberDetail(int majorOnDs);
	
	//得到成接口
	public List< DS_Member> getMember(int currentPage);
	
	//根据id更新接口
	public void updateMember(String id,String name,boolean female,int majorOnDs,String major,int grade,int cla,String description,String img,String leavingWord,String savePath);
	
	//根据id删除接口
	public void deleteMember(String memberId);
	
	//得到总数
	public Long getCountAll();
	
	//根据Id来得到member
	public DS_Member getMemberById(String id);
	
	public void deleteTempImage();
}
