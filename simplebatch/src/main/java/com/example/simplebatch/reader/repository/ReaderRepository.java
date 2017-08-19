package com.example.simplebatch.reader.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.simplebatch.reader.entity.ReadEntity;

@Repository
public interface ReaderRepository extends JpaRepository<ReadEntity, Long>{
//    where numero = 3799408
//	@Query("from ReadEntity")
//    Page<ReadEntity> findAllEntities(Pageable pageable);

}
