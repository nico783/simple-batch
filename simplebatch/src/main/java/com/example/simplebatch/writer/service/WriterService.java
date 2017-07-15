package com.example.simplebatch.writer.service;

import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.simplebatch.reader.entity.ReadEntity;
import com.example.simplebatch.writer.entity.WriteEntity;
import com.example.simplebatch.writer.repository.WriterRepository;

@Service
public class WriterService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private WriterRepository WriterRepository;

	@Transactional
	public void write(Stream<ReadEntity> readEntities) {
		readEntities.map(x -> process(x)).forEach(writeAndClear());
	}

	/**
	 * Applique un traitement sur les données lues.
	 * 
	 * @param x
	 * @return
	 */
	private WriteEntity process(ReadEntity x) {
		WriteEntity writeEntity = new WriteEntity();
		writeEntity.setFirstName(x.getName());
		writeEntity.setId(x.getId());
		writeEntity.setLastName("nico");
		return writeEntity;
	}

	private Consumer<WriteEntity> writeAndClear() {
		// entityManager.clear();
		return t -> WriterRepository.saveAndFlush(t);
	}

}
