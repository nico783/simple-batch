package com.example.simplebatch.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
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

    /**
     * Lit l'ensemble des données de type ReadEntity par page de "batchSize" éléments.
     * Transforme ces données en type WriteEntity.
     * Ecrit dans la base de données.
     * Recommence tant qu'il y a des données non traitées.
     */
    public void execute() {
        int batchSize = Integer.parseInt(stringBatchSize);
        boolean isFinish = false;
        int page = 0;
        while (!isFinish) {
            Slice<ReadEntity> readEntities = readerService.findAllEntities(page, batchSize);
            writerService.write(process(readEntities));
            isFinish = readEntities.isLast();
            ++page;
        }
    }

    /**
     * Applique un traitement sur les données lues.
     *
     * @param readEntities entités lues.
     * @return Entités à écrire
     */
    private List<WriteEntity> process(Slice<ReadEntity> readEntities) {
        List<WriteEntity> results = new ArrayList<>();

        for (ReadEntity readEntity : readEntities) {
            WriteEntity writeEntity = new WriteEntity();
            writeEntity.setCustomerKey(readEntity.getClient().toString());
            writeEntity.setLogin("charge test");
            writeEntity.setPassword("mdp");
            writeEntity.setRateBand("A");
            writeEntity.setCustomerType("NORMAL");
            writeEntity.setCreationDate(new Date());
            writeEntity.setChangeDate(new Date());
            writeEntity.setHandle_idFK(220390l);
            writeEntity.setCreatedBy("charge test");
            writeEntity.setIsAccountValidated(0);
            writeEntity.setLastLoginDate(new Date());
            writeEntity.setIsMarguerite(0);
            writeEntity.setSegment_tva("00");
            writeEntity.setFacture_0_euro("0");
            writeEntity.setPayment_period("15 jours");
            writeEntity.setSendDocumentBy("EMAIL");
            writeEntity.setOrangeCode("orange123");
            results.add(writeEntity);
        }

        return results;
    }

}
