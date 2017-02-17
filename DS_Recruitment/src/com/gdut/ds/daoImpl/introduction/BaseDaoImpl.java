package com.gdut.ds.daoImpl.introduction;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.gdut.ds.dao.introduction.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	//通过spring hibernate 来注入sessionFactory
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		//System.out.println("BaseDaoImpl get sessionFactory==null:"+(sessionFactory==null));
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		//System.out.println("BaseDaoImpl set sessionFactory==null:"+(sessionFactory==null));
		this.sessionFactory = sessionFactory;
	}
	
	//保存某个对象
	public void save(T entity) {
		//System.out.println("BaseDaoImpl save sessionFactory==null:"+(sessionFactory==null));
		sessionFactory.getCurrentSession().save(entity);
	}
	
	//更新某个对象
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}
	
	
	//根据对象来进行删除
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
		
	}
	
	
	//根据ID来删除
	public void delete(Class<T> entityClazz, Serializable id) {
		sessionFactory.getCurrentSession().createQuery("delete from "+entityClazz.getSimpleName()+" where id=:ID").setParameter("ID", id).executeUpdate();
		
	}

	
	//根据hql来查找某个集合，可以实现分页查找
	public List<T> find(String hql) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setCacheable(true);					//设置查询缓存
		return (List<T>)query.list();
	}
	
	//根据hql和参数来查找某个集合，可以实现分页查找
	public List<T> find(String hql, Object... params) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setCacheable(true);						//设置查询缓存
		for(int i=0;i<params.length;i++){
			q.setParameter(i, params[i]);
		}
		
		return (List<T>)q.list();
	}
	
	//根据对象类型来查找所有的对象
	public List<T> findAll(Class<T> entityClazz) {
		Query query = sessionFactory.getCurrentSession().createQuery("from "+entityClazz.getSimpleName());
		query.setCacheable(true);						//设置查询缓存
		return (List<T>)query.list();
	}
	
	//根据hql来查找特定的对象
	public T findByHQL(String hql) {
		
		return (T)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
	}
	
	//根据hql和参数来查找特定的对象
	public T findByHQL(String hql, Object... params) {
		
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i=0;i<params.length;i++){
			q.setParameter(i, params[i]);
		}
		return (T)q.uniqueResult();
	}
	
	//查找某个对象的总和
	public Long findCount(Class<T> entityClazz) {
		
		return (Long)sessionFactory.getCurrentSession().createQuery("select count(*) from "+entityClazz.getSimpleName()).uniqueResult();
	}
	
	//根据hql语句和参数来查找总和
	public Long findCount(String hql,Object... params) {
		
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		
		for(int i=0;i<params.length;i++){
			q.setParameter(i, params[i]);
		}
		return (Long)q.uniqueResult();
		
	}
	
	//根据ID来得到某个对象
	public T get(Class<T> entityClazz, Serializable id) {
		
		return (T)sessionFactory.getCurrentSession().get(entityClazz, id);
	}
	
	//分页查找
	public List<T> findByPage(String hql, int start, int pageSize) {
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setFirstResult(start).setMaxResults(pageSize);
		//query.setCacheable(true);             		//设置查询缓存
		return (List<T>)query.list();
		
	}

	//根据hql操作
	public void operate(String hql) {
		
		sessionFactory.getCurrentSession().createQuery(hql);
	}

	

}
