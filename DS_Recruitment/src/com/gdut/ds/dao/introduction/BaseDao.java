package com.gdut.ds.dao.introduction;

import java.io.Serializable;
import java.util.List;
/*
 * 
 * Hibernate 保存的一系列动作
 * 
 * 
 * */

public interface BaseDao<T> {
	
	//根据 id来返回T
	T get(Class<T> entityClazz,Serializable id);
	
	//保存
	void save(T entity);
	
	void update(T entity);
	
	//删除
	void delete(T entity);
	
	//根据ID来删除
	void delete(Class<T> entityClazz,Serializable id);
	
	//根据hql来操作
	void operate(String hql);
	
	//查找所有的
	List<T> findAll(Class<T> entityClazz);
	
	//查找所有的数量
	Long findCount(Class<T> entityClazz);
	
	//根据hql来和参数来得到某个数量
	Long findCount(String hql,Object... params) ;
	
	//查找特定的
	T findByHQL(String hql);
	
	//根据参数来查找特定的
	T findByHQL(String hql,Object...params);
	
	//根据hql来查找多个
	List<T> find(String hql);
	
	//根据参数来查找多个
	List<T> find(String hql,Object...params);
	
	//分页查找
	List<T> findByPage(String hql,int start,int pageSize);
}
