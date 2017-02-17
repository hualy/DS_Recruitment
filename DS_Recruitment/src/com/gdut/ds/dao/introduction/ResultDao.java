package com.gdut.ds.dao.introduction;

import java.util.List;

import com.gdut.ds.beans.introduction.DS_Result;

public interface ResultDao extends BaseDao<DS_Result> {
	
	//分页，并且分类型
	public List<DS_Result> findByPage(int start,int pageSize,int type);
}
