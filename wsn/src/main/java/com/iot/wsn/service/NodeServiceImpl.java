package com.iot.wsn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.wsn.dao.NodeDAO;
import com.iot.wsn.model.Node;
import com.iot.wsn.model.Sensor;

@Service
public class NodeServiceImpl implements NodeService{

	@Autowired
	NodeDAO dao;
	
	@Autowired
	SensorService sensorService;
	
	@Override
	public Node create(Node nodeToCreate, Integer id) {
		final Optional<Sensor> sensor = sensorService.findById(id);
		nodeToCreate.setSensor(sensor.get());
		
		return dao.save(nodeToCreate);
	}

	@Override
	public Optional<Node> findById(Integer idNode) {
		return dao.findById(idNode);
	}

}
