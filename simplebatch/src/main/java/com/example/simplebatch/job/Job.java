package com.example.simplebatch.job;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.simplebatch.reader.entity.ReadEntity;
import com.example.simplebatch.reader.service.ReaderService;
import com.example.simplebatch.writer.entity.WriteEntity;
import com.example.simplebatch.writer.service.WriterService;

@Component
public class Job {
	
	@Value(value = "${batch.size}")
	private String stringBatchSize;
	
	@Autowired
	private ReaderService readerService;

	@Autowired
	private WriterService writerService;

	@Transactional
	public void execute() {
		int batchSize = Integer.parseInt(stringBatchSize);
		
		// Récupération de l'ensemble des données dans un flux.
		Stream<ReadEntity> readEntities = readerService.findAllEntities();
		
		// Transformation des données puis écriture en bdd.
		readEntities.map(x -> process(x)).forEach(t -> writerService.write(t, batchSize));
	}
	
	/**
	 * Applique un traitement sur les données lues.
	 * 
	 * @param Entité lue
	 * @return Entité à écrire
	 */
	private WriteEntity process(ReadEntity x) {
		WriteEntity writeEntity = new WriteEntity();
		writeEntity.setFirstName(x.getPrenom());
		writeEntity.setId(x.getId());
		writeEntity.setLastName(x.getNom());
		return writeEntity;
	}

}
