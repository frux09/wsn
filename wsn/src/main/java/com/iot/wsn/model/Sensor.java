package com.iot.wsn.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idSensor;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	private Node node; */
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sensor")
	private List<Node> node = new ArrayList<>();
	
	private String typeSensor;
	
	
}
