package com.iot.wsn.service;

import java.util.Optional;

import com.iot.wsn.model.Node;

public interface NodeService {

	Node create(Node nodeToCreate, Integer id);

	Optional<Node> findById(Integer idNode);
}
