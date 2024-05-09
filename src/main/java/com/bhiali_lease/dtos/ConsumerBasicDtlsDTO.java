package com.bhiali_lease.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerBasicDtlsDTO {
	private Long wardNo;
	private String consumerNo;
	private String consumerName;
	private Long contactNo;
	private String address;
	private BigDecimal area;
	private int usesType;
	private BigDecimal amt;
	private String startDate;
	private String endDate;
	private int status;
	
}
