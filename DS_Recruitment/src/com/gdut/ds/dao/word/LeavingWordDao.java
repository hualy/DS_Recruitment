package com.gdut.ds.dao.word;

import java.util.List;

import com.gdut.ds.beans.word.LeavingWord;
import com.gdut.ds.dao.introduction.BaseDao;

public interface LeavingWordDao extends BaseDao<LeavingWord> {
		
	//根据Id来得到值
	List<LeavingWord> findByIds(List<String> ids);
		
	
		
		
}
