package com.iot.wsn.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Data {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idData;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Node node;
	
	private Double value;
	
	private String date;
}
