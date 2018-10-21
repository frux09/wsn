package com.iot.wsn.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Node {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idNode;
	
	private String board;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "node")
	private List<Data> data = new ArrayList<>();
	
	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "node")
	private List<Sensor> sensor = new ArrayList<>(); */
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Sensor sensor;
	
	private String location;
}
