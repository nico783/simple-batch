package com.example.simplebatch.writer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simplebatch.reader.entity.ReadEntity;
import com.example.simplebatch.writer.entity.WriteEntity;

@Repository
public interface WriterRepository extends JpaRepository<WriteEntity, Long>{

}
