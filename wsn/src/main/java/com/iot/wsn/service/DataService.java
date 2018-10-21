package com.iot.wsn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.iot.wsn.dto.DataDTO;
import com.iot.wsn.model.Data;

public interface DataService {

	Optional<Data> findById(Integer id);
	
	List<Data> findAll(Pageable p);
	
	Data create(Data dataToCreate, Integer idNode);
	
	void update(Data dataToUpdate);
	
	void delete(Integer id);

	List<Data> findByQuery(Double value);
}
