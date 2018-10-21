package com.iot.wsn.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SensorDTO {

	private Integer idSensor;
	private String typeSensor;	
}
