package com.example.simplebatch.writer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.simplebatch.writer.entity.WriteEntity;
import com.example.simplebatch.writer.repository.WriterRepository;

@Service
public class WriterService {
	
	@Autowired
	private WriterRepository writerRepository;
	
	private long compteur = 0;

	@Transactional
	public synchronized void write(WriteEntity entity, int batchSize) {
		writerRepository.save(entity);
		compteur++;
		
		if (compteur % batchSize == 0) {
			writerRepository.flushAndClear();
		}
	}
	
}
