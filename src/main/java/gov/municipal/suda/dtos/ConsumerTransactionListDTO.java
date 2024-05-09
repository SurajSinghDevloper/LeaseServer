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
public class ConsumerTransactionListDTO {

	private String TransactionNo;	
	private String TransactionDate;
	private String FromYear;
	private String UptoYear;
	private String PaymentMode;
	private BigDecimal payableAmount;
	private String CollectedBy;
}
