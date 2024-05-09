package gov.municipal.suda.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class LeasePaymentModeReport {

	private Long total_count;
	private BigDecimal total_amt;
	
	private String payment_mode;
	
	
	
	
}
