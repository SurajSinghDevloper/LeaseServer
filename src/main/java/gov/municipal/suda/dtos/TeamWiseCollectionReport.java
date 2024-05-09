package gov.municipal.suda.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class TeamWiseCollectionReport {

	private String collector_name;
	private String collector_type;
	private  Long total_applicant;
	private BigDecimal total_collections;
	private Long user_id;
	
}
