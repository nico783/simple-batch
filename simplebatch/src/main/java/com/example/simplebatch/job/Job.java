package com.example.simplebatch.job;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.simplebatch.reader.entity.ReadEntity;
import com.example.simplebatch.reader.service.ReaderService;
import com.example.simplebatch.writer.service.WriterService;

@Component
public class Job {
	
	@Value(value = "${batch.size}")
	private String batchSize;

	@Autowired
	private ReaderService readerService;

	@Autowired
	private WriterService writerService;

	@Transactional
	public void execute() {
		// Obtenir l'ensemble des données à traiter
		Stream<ReadEntity> readEntities = readerService.findAllEntities();
		
		writerService.write(readEntities);
		
	}

}
