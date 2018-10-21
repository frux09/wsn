package com.iot.wsn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.iot.wsn.dao.DataDAO;
import com.iot.wsn.dto.DataDTO;
import com.iot.wsn.model.Data;
import com.iot.wsn.model.Node;

@Service
public class DataServiceImpl implements DataService{

	@Autowired
	DataDAO dao;
	@Autowired
	NodeService nodeService;
	
	@Override
	public Optional<Data> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Data> findAll(Pageable p) {
		return dao.findAll(p).getContent();
	}

	@Override
	public Data create(Data dataToCreate, Integer idNode) {
		final Optional<Node> node = nodeService.findById(idNode);
		dataToCreate.setNode(node.get());
		
		return dao.save(dataToCreate);
	}

	@Override
	public void update(Data dataToUpdate) {
		dao.saveAndFlush(dataToUpdate);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Data> findByQuery(Double value) {
		return dao.findByValueGreaterThanOrderByNodeDesc(value);
	}

}
