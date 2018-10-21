package com.iot.wsn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iot.wsn.model.Sensor;

public interface SensorDAO extends JpaRepository<Sensor, Integer> {

}
