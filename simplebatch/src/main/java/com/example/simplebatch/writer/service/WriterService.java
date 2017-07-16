package com.example.simplebatch.writer.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.simplebatch.reader.entity.ReadEntity;
import com.example.simplebatch.writer.entity.WriteEntity;
import com.example.simplebatch.writer.repository.WriterRepository;

@Service
public class WriterService {
	
	@Value(value = "${batch.size}")
	private String stringBatchSize;

	@Autowired
	private WriterRepository writerRepository;
	
	private long compteur = 0;

	@Transactional
	public void write(Stream<ReadEntity> readEntities) {
		int batchSize = Integer.parseInt(stringBatchSize);
		readEntities.map(x -> process(x)).forEach(t -> writeAndClear(t, batchSize));
	}
	
	private synchronized void writeAndClear(WriteEntity entity, int batchSize) {
		// WriteEntity persistentEntity =
		writerRepository.save(entity);
		compteur++;
		
		if (compteur % batchSize == 0) {
			writerRepository.flushAndClear();
			System.out.println("Nombre de lignes insérées : " + compteur);
		}

		// System.out.println(writerRepository.contains(persistentEntity));
		// System.out.println(writerRepository.contains(entity));
	}
	
	/**
	 * Applique un traitement sur les données lues.
	 * 
	 * @param x
	 * @return
	 */
	private WriteEntity process(ReadEntity x) {
		WriteEntity writeEntity = new WriteEntity();
		writeEntity.setFirstName(x.getPrenom());
		writeEntity.setId(x.getId());
		writeEntity.setLastName(x.getNom());
		return writeEntity;
	}

}
