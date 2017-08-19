package com.example.simplebatch.reader.repository;

import com.example.simplebatch.reader.entity.ReadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<ReadEntity, Long>{

}
