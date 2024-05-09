package gov.municipal.suda.dtos;

import java.math.BigDecimal;

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
public class ConsumerDemandListDTO {
	
	private String fy_year;
	private Long demand_amount;
	private Long penalty;
	private Long payable_amount;

}
