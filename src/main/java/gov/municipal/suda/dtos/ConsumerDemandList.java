package gov.municipal.suda.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerDemandList {

	private List<ConsumerDemandListDTO> demandList;
	private String demand_from;
	private String demand_to;
	private Long demand_amount;
	
	
	
}
