package com.iot.wsn.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iot.wsn.model.Data;

public interface DataDAO extends JpaRepository<Data, Integer> {

	List<Data> findByValueGreaterThanOrderByNodeDesc(Double value);

	Page<Data> findAll(Pageable p);
}
