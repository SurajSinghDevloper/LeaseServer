package gov.municipal.suda.dtos;

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
	private Double area;
	private Long usesType;
	private Double amt;
	private String startDate;
	private String endDate;
	private Long status;
	
}
