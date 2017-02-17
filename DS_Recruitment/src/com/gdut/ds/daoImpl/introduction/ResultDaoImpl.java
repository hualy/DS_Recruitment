package com.gdut.ds.daoImpl.introduction;

import java.util.List;

import com.gdut.ds.beans.introduction.DS_Result;
import com.gdut.ds.dao.introduction.ResultDao;

public class ResultDaoImpl extends BaseDaoImpl<DS_Result> implements ResultDao {

	public List<DS_Result> findByPage(int start, int pageSize, int type) {
		return (List<DS_Result>)getSessionFactory().getCurrentSession().createQuery("from DS_Result r where r.type=? ").setParameter(0, type).setFirstResult(start).setMaxResults(pageSize).list();
	}

	

}
