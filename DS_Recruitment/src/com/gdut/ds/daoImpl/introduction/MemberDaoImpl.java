package com.gdut.ds.daoImpl.introduction;

import java.util.List;

import com.gdut.ds.beans.introduction.DS_Member;
import com.gdut.ds.dao.introduction.MemberDao;

public class MemberDaoImpl extends BaseDaoImpl<DS_Member> implements MemberDao {

	public List<DS_Member> findByPage(int start,int pageSize, int majorOnDs) {
		return (List<DS_Member>)this.getSessionFactory().getCurrentSession()
		.createQuery("from DS_Member m where m.majorOnDs=:majorOnDs").setParameter("majorOnDs", majorOnDs)
		.setFirstResult(start).setMaxResults(pageSize).list();
	}

}
