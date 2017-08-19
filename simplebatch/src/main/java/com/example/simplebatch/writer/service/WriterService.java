package com.example.simplebatch.writer.service;

import com.example.simplebatch.writer.entity.WriteEntity;
import com.example.simplebatch.writer.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    /**
     * Ecrit l'ensemble des données passées en paramètre en base de données.
     * @param entities
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void write(List<WriteEntity> entities) {
        for (WriteEntity entity : entities) {
            // Enregistrement seulement si le client n'existe pas déjà.
            if (!writerRepository.existsByCustomerKey(entity.getCustomerKey())) {
                writerRepository.save(entity);
            }
        }
    }

}
