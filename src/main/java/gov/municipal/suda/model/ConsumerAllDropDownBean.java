package gov.municipal.suda.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ConsumerAllDropDownBean {
	private List<GSTMaster> gstMaster;
	private List<LeaseUsageType> usageType;
	private List<FinancialYear> fyYear;
	private List<LeaseAreaMaster> areaMaster;
	
	
	
	
}
