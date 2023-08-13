package com.eddu.pe.tit.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.eddu.pe.tit.utiles.EntityManagerUtil;

public abstract class AbastractDao<T> implements Dao<T> {

	
	private EntityManager manager = EntityManagerUtil.getEntityManager();
	
	private Class<T> clazz;
	


	public EntityManager getManager() {
		return manager;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Optional<T> get(long id) {
 
		return Optional.ofNullable(manager.find(clazz, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		String qstr = "FROM " + clazz.getName();
		Query query = manager.createQuery(qstr);
		return query.getResultList();
	}

	@Override
	public void save(T t) {
		ejecutarTransaccion(manager -> manager.persist(t));
		
	}

	@Override
	public void update(T t) {
		ejecutarTransaccion(manager -> manager.merge(t));

		
	}

	@Override
	public void delete(T t) {

		ejecutarTransaccion(manager -> manager.remove(t));

	}

	
	
	
	private void ejecutarTransaccion(Consumer<EntityManager> action) {
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			action.accept(manager);
			tx.commit();
			
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
