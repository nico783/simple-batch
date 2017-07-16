package com.example.simplebatch.writer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplebatch.writer.entity.WriteEntity;

public interface WriterRepository extends JpaRepository<WriteEntity, Long>, RepositoryCustom<WriteEntity, Long>{

}
