package com.iot.wsn.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.wsn.dto.DataDTO;
import com.iot.wsn.model.Data;
import com.iot.wsn.service.DataService;

@Component
public class DataMapperImpl implements DataMapper{

	@Autowired
	DataService service;
	
	@Override
	public Data mapToModel(DataDTO dto) {
		final Data data = service.findById(dto.getIdData()).orElse(new Data());
		
		data.setIdData(dto.getIdData());
		data.setValue(dto.getValue());
		data.setDate(dto.getDate());
		
		return data;
	}

	@Override
	public DataDTO mapToDTO(Data model) {
		return DataDTO.builder()
				.idData(model.getIdData())
				.value(model.getValue())
				.date(model.getDate())
				.build();
	}

	@Override
	public List<DataDTO> mapToDTO(List<Data> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
