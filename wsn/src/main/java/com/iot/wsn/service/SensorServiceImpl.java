package com.iot.wsn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.wsn.dao.SensorDAO;
import com.iot.wsn.model.Sensor;

@Service
public class SensorServiceImpl implements SensorService{

	@Autowired
	SensorDAO dao;
	
	@Override
	public Sensor create(Sensor sensorToCreate) {
		return dao.save(sensorToCreate);
	}

	@Override
	public Optional<Sensor> findById(Integer idSensor) {
		return dao.findById(idSensor);
	}
	

}
