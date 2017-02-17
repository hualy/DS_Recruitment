package com.gdut.ds.service;

import java.util.List;
import java.util.Set;

import com.gdut.ds.beans.introduction.DS_Result;
import com.gdut.ds.beans.introduction.Image;

public interface ResultService {
	
	
	
	//创造成果的接口
	public void createResult(String theme,String leaderName,String membersName,String date,int type,String description,Set<Image> images);
	
	//得到成果接口
	public List<DS_Result> getResult(int currentPackage);
	//得到成果接口
	public DS_Result getResultDetail(int currentPackage,int type);
	
	//根据id更新接口
	public void updateResult(String id,String theme,String leaderName,String membersName, String date, int type,
			String description,boolean resetPicture, Set<Image> images) ;
	
	//根据id删除接口
	public void deleteResult(String resultId);
	
	//根据id得到某个接口
	public DS_Result getResultById(String id);
	
	//得到总数
	public Long getCountAll();
	
	//根据类型得到总数
	public Long getCountByType(int type);
	
}
