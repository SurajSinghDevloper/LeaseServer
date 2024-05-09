package com.bhiali_lease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhiali_lease.dtos.ConsumerBasicDtlsDTO;
import com.bhiali_lease.service.LeaseConsumerMasterService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/consumers")
public class ConsumerController {

	@Autowired
	private  LeaseConsumerMasterService consumerService;
	
	 @GetMapping("/get-all")
	    public ResponseEntity<List<ConsumerBasicDtlsDTO>> getAllLeaseConsumerDetails() {
	        List<ConsumerBasicDtlsDTO> leaseConsumerDetails = consumerService.allConsumerBasicDetails();
	        return new ResponseEntity<>(leaseConsumerDetails, HttpStatus.OK);
	    }
	
}
