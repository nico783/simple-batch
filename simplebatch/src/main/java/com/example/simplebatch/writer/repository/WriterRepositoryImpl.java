package com.example.simplebatch.writer.repository;

import com.example.simplebatch.writer.entity.WriteEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
