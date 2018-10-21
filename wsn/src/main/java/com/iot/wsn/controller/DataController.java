package com.iot.wsn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iot.wsn.dto.DataDTO;
import com.iot.wsn.mapper.DataMapper;
import com.iot.wsn.model.Data;
import com.iot.wsn.service.DataService;

@RestController
@RequestMapping(value = "/node/{idNode}/data")
public class DataController {

	@Autowired
	DataService dataService;
	@Autowired
	DataMapper dataMapper;
	
	@GetMapping
	public List<DataDTO> findAll(
			@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
			@RequestParam(defaultValue = "4", value = "size", required = false) Integer size) {
		
		final List<Data> datas = dataService.findAll(PageRequest.of(page, size));
		
		return dataMapper.mapToDTO(datas);
	}
	
	@GetMapping("/{idData}")
	public DataDTO findById(@PathVariable Integer idData) {
		Optional<Data> data = dataService.findById(idData);
		
		return dataMapper.mapToDTO(data.get());
	}
	
	@GetMapping("/query/{value}")
	public List<DataDTO> findAllByQuery(@PathVariable Double value) {
		List<Data> data = dataService.findByQuery(value);
		
		return dataMapper.mapToDTO(data);
	}
	
	@PostMapping
	public DataDTO create(@PathVariable Integer idNode, @RequestBody DataDTO dataDTO) {
		final Data dataToCreate = dataMapper.mapToModel(dataDTO);
		final Data dataCreated = dataService.create(dataToCreate, idNode);
		
		return dataMapper.mapToDTO(dataCreated);
	}
	
	@PutMapping("/{idData}")
	public void update(@RequestBody DataDTO dataDTO, @PathVariable Integer idData) {
		final Data data = dataMapper.mapToModel(dataDTO);
		data.setIdData(idData);
		
		dataService.update(data);
	}
	
	@DeleteMapping("/{idData}")
	public void delete(@PathVariable Integer idData) {
		dataService.delete(idData);
	}
}
