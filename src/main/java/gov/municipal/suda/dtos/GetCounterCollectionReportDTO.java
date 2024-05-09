package gov.municipal.suda.dtos;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class GetCounterCollectionReportDTO {

	
	private Long wardId;
    private String leaseNo;
    private String consumerName;
    private Long mobNo;
    private String corresAddress;
    private String areaAddr;
    private String paymentMode;
    private Long demandAmount;
    private String transNo;
    private String firstFyYear;
    private String lastFyYear;
    private Date transactionDate;
    private String bank;
    private String branch;
    private String cardHolderName;
    private String cardNo;
    private String cardType;
    private Date chequeDdNeftDate;
    private String chequeDdNeftNo;
    private BigDecimal gstAmount;
    private Long userId;
}
