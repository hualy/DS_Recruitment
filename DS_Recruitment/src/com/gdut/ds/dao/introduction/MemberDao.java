package com.gdut.ds.dao.introduction;

import java.util.List;

import com.gdut.ds.beans.introduction.DS_Member;

public interface MemberDao extends BaseDao<DS_Member> {
	 List<DS_Member> findByPage(int start,int pageSize, int majorOnDs) ; //根据方向实现分布操作
}
