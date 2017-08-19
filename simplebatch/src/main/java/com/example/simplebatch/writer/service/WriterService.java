package com.example.simplebatch.writer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.simplebatch.writer.entity.WriteEntity;
import com.example.simplebatch.writer.repository.WriterRepository;

import java.util.List;

@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    private long compteur = 0;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public synchronized void write(List<WriteEntity> entities, int batchSize) {
        for (WriteEntity entity : entities) {
            // Enregistrement seulement si le client n'existe pas déjà.
            if (!writerRepository.existsByCustomerKey(entity.getCustomerKey())) {
                writerRepository.save(entity);
                compteur++;

                if (compteur % batchSize == 0) {
                    writerRepository.flushAndClear();
                }
            }
        }
    }

}
