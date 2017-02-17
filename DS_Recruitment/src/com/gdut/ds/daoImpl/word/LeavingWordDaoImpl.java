package com.gdut.ds.daoImpl.word;

import java.util.List;

import com.gdut.ds.beans.word.LeavingWord;
import com.gdut.ds.dao.word.LeavingWordDao;
import com.gdut.ds.daoImpl.introduction.BaseDaoImpl;

public class LeavingWordDaoImpl extends BaseDaoImpl<LeavingWord> implements LeavingWordDao {
	

	
	
//根据一系列的id值来返回留言
	public List<LeavingWord> findByIds(List<String> ids) {
		return (List<LeavingWord>)getSessionFactory().getCurrentSession().createQuery("from LeavingWord l where l.id in(:ids)")
					.setParameterList("ids", ids).list();
	}

	
	

}
