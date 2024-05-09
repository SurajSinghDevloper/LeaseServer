package gov.municipal.suda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

import gov.municipal.suda.dtos.ConsumerAllDetailsDto;
import gov.municipal.suda.dtos.ConsumerBasicDtlsDTO;
import gov.municipal.suda.service.LeaseConsumerMasterService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/consumers")
public class ConsumerController {

	@Autowired
	private  LeaseConsumerMasterService consumerService;
	
	
	    @GetMapping("/get-all")
	    public Page<ConsumerBasicDtlsDTO> getAllLeaseConsumerDetails(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        return consumerService.allConsumerBasicDetails(page, size);
	    }
	    @GetMapping("/leasae-no")
	    public ConsumerAllDetailsDto getLeaseConsumerDetails(@RequestParam("leasaeNo") String leasaeNo ){
	    	return consumerService.getDetails(leasaeNo);
	    }
	    
	    
	    
	    
}
