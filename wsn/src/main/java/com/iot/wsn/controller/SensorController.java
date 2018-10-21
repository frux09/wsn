package com.iot.wsn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iot.wsn.dto.SensorDTO;
import com.iot.wsn.mapper.SensorMapper;
import com.iot.wsn.model.Sensor;
import com.iot.wsn.service.SensorService;

@RestController
@RequestMapping(value = "/sensor")
public class SensorController {

	@Autowired
	SensorMapper mapper;
	@Autowired
	SensorService sensorService;
	
	@GetMapping("/{idSensor}")
	public SensorDTO findById(@PathVariable Integer idSensor) {
		final Optional<Sensor> sensor = sensorService.findById(idSensor);
		
		return mapper.mapToDTO(sensor.get());
	}
	
	@PostMapping
	public SensorDTO create(@RequestBody SensorDTO sensorToCreate) {
		final Sensor sensor = mapper.mapToModel(sensorToCreate);
		final Sensor sensorCreated = sensorService.create(sensor);
		
		return mapper.mapToDTO(sensorCreated);
	}
}
