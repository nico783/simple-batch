package com.example.simplebatch.reader.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.simplebatch.reader.entity.ReadEntity;

@Repository
public interface ReaderRepository extends JpaRepository<ReadEntity, Long>{

	@Query("from ReadEntity order by id")
	Stream<ReadEntity> findAllEntities();

}
