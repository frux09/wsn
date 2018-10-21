package com.iot.wsn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iot.wsn.dto.NodeDTO;
import com.iot.wsn.mapper.NodeMapper;
import com.iot.wsn.model.Node;
import com.iot.wsn.service.NodeService;

@RestController
@RequestMapping(value = "/sensor/{idSensor}/node")
public class NodeController {

	@Autowired
	NodeService nodeService;
	@Autowired
	NodeMapper nodeMapper;
	
	
	@GetMapping("/{idNode}")
	public NodeDTO findById(@PathVariable Integer idNode) {
		final Optional<Node> node = nodeService.findById(idNode);
		
		return nodeMapper.mapToDTO(node.get());
	}
	
	@PostMapping
	public NodeDTO create(@PathVariable Integer idSensor, @RequestBody NodeDTO nodeDTO) {
		final Node nodeToCreate = nodeMapper.mapToModel(nodeDTO); 
		final Node nodeCreated = nodeService.create(nodeToCreate, idSensor);
		
		return nodeMapper.mapToDTO(nodeCreated);
	}
}
