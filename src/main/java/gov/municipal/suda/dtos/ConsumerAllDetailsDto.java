package gov.municipal.suda.dtos;

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

public class ConsumerAllDetailsDto {
	private Long ward_id;
	private Long consumerID;
	private String consumerName;
	private String gurdianName;
	private Long mobileNo;
	private String relation;
	private String emailId;
	private String address;
	private String leaseNo;
	private String leaseArea;
	private String usesOfLand;
	private String areaDimension;
	private float totalArea;
	private String plotAddress;
	private Double leaseAmt;
	private String leaseStartDate;
	private String leaseEndDate;
	
	
}
