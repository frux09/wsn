package com.iot.wsn.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.wsn.dto.SensorDTO;
import com.iot.wsn.model.Sensor;
import com.iot.wsn.service.SensorService;

@Component
public class SensorMapperImpl implements SensorMapper{

	@Autowired
	SensorService service;
	
	@Override
	public Sensor mapToModel(SensorDTO dto) {
		
		final Sensor sensor = service.findById(dto.getIdSensor()).orElse(new Sensor());
		
		sensor.setIdSensor(dto.getIdSensor());
		sensor.setTypeSensor(dto.getTypeSensor());
		
		return sensor;
	}

	@Override
	public SensorDTO mapToDTO(Sensor model) {

		return SensorDTO.builder()
				.idSensor(model.getIdSensor())
				.typeSensor(model.getTypeSensor())
				.build();
	}

	@Override
	public List<SensorDTO> mapToDTO(List<Sensor> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

	
}
