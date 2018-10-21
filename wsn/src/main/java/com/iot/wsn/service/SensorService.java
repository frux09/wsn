package com.iot.wsn.service;

import java.util.Optional;

import com.iot.wsn.model.Sensor;

public interface SensorService {

	Sensor create(Sensor sensorToCreate);

	Optional<Sensor> findById(Integer idSensor);
}
