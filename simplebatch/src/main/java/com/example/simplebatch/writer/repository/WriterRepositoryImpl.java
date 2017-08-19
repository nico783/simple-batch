package com.example.simplebatch.writer.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.simplebatch.writer.entity.WriteEntity;

@Repository
public class WriterRepositoryImpl implements RepositoryCustom<WriteEntity, Long>{

	@PersistenceContext(unitName = "writedb")
	private EntityManager entityManager;

	@Override
	public void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}
	
	@Override
	public boolean contains(WriteEntity entity) {
		return entityManager.contains(entity);
	}



}
