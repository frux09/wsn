package com.iot.wsn.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NodeDTO {

	private Integer idNode;
	private String board;
	private String location;
}
