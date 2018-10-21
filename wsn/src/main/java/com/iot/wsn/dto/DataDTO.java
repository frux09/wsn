package com.iot.wsn.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataDTO {

	private Integer idData;
	private Double value;
	private String date;
}
