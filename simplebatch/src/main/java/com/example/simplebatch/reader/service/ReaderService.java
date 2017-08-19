package com.example.simplebatch.reader.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.simplebatch.reader.entity.ReadEntity;
import com.example.simplebatch.reader.repository.ReaderRepository;

@Service
public class ReaderService {
	
	@Autowired
	private ReaderRepository readerRepository;

	@Transactional
	public Page<ReadEntity> findAllEntities(int page, int numberElementByPage) {
		return readerRepository.findAll(new PageRequest(page, numberElementByPage));
	}

}
