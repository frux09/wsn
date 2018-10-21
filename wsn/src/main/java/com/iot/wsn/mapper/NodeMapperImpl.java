package com.iot.wsn.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.wsn.dto.NodeDTO;
import com.iot.wsn.model.Node;
import com.iot.wsn.service.NodeService;

@Component
public class NodeMapperImpl implements NodeMapper{

	@Autowired
	NodeService service;
	
	@Override
	public Node mapToModel(NodeDTO dto) {
		final Node node = service.findById(dto.getIdNode()).orElse(new Node());
		
		node.setIdNode(dto.getIdNode());
		node.setBoard(dto.getBoard());
		node.setLocation(dto.getLocation());
				
		return node;
	}

	@Override
	public NodeDTO mapToDTO(Node model) {
		return NodeDTO.builder()
				.idNode(model.getIdNode())
				.board(model.getBoard())
				.location(model.getLocation())
				.build();
	}

	@Override
	public List<NodeDTO> mapToDTO(List<Node> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
