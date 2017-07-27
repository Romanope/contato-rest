package com.apirest.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.apirest.hibernate.HibernateSession;

public abstract class GenericDAO<T> {

	private SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	
	private Class<T> persistenceClass;
	
	protected abstract void validarDados(T obj);
	
	protected GenericDAO() {
		persistenceClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T save(T obj) {
		
		//validar dados
		validarDados(obj);
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(obj);
		
		session.getTransaction().commit();
		
		return obj;
	}
	
	public List<T> listAll() {
		
		try {
			Session session = sessionFactory.openSession();
			return session.createCriteria(persistenceClass).list();
		} finally {
			
		}
	}
}
