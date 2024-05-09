package gov.municipal.suda.service;


import org.springframework.data.domain.Page;

import gov.municipal.suda.dtos.ConsumerAllDetailsDto;
import gov.municipal.suda.dtos.ConsumerBasicDtlsDTO;

public interface LeaseConsumerMasterService {
	public Page<ConsumerBasicDtlsDTO> allConsumerBasicDetails(int page, int size);
	
	 public ConsumerAllDetailsDto getDetails(String consumerMasterId);
}
