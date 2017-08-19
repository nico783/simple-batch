package com.example.simplebatch.reader.service;

import com.example.simplebatch.reader.entity.ReadEntity;
import com.example.simplebatch.reader.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    /**
     * Lit une partie des données.
     * La méthode s'execute dans une nouvelle transaction a chaque fois, dans le but de ne pas surcharger le
     * cache de niveau 1 d'Hibernate avec l'ensemble total des données. Si ce service n'est pas executé dans une
     * méthode déjà transactionnelle, la precision "Propagation.REQUIRES_NEW" est facultative.
     *
     * @param page                Indique la page lue.
     * @param numberElementByPage Nombre d'éléments contenus dans une page.
     * @return L'ensemble des données lues.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Slice<ReadEntity> findAllEntities(int page, int numberElementByPage) {
        return readerRepository.findAll(new PageRequest(page, numberElementByPage));
    }

}
