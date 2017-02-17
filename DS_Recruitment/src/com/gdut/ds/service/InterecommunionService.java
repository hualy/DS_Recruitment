package com.gdut.ds.service;

import java.util.List;
import java.util.Set;

import com.gdut.ds.beans.introduction.DS_Interecommunion;
import com.gdut.ds.beans.introduction.Image;

public interface InterecommunionService {
	
	
	
	//创造成果的接口
	public void createInterecommunion(String theme,String date,String speaker,String presenter,String content,Set<Image> images);
	
	//得到成果接口
	public DS_Interecommunion getInterecommunionDetail(int currentPage);
	
	//得到好多个成果接口
	public List<DS_Interecommunion> getInterecommunions(int currentPackage);
	
	//根据id更新接口
	public void updateInterecommunion(String id,String theme,String date,String speaker,String presenter,String content,boolean resetPicture,Set<Image> images); ;
	
	//根据id删除接口
	public void deleteInterecommunion(String interecommunionId);
	
	//根据id得到某个接口
	public DS_Interecommunion getInterecommunionById(String id);
	
	//得到总数
	public Long getCountAll();
}
