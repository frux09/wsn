package com.iot.wsn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iot.wsn.model.Node;

public interface NodeDAO extends JpaRepository<Node, Integer> {

}
