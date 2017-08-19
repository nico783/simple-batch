package com.example.simplebatch.writer.repository;

import com.example.simplebatch.writer.entity.WriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<WriteEntity, Long>, RepositoryCustom<WriteEntity, Long>{

    boolean existsByCustomerKey(String customerKey);

}
