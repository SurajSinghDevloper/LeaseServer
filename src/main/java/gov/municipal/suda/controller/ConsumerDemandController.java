package gov.municipal.suda.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.municipal.suda.dtos.ConsumerDemandList;
import gov.municipal.suda.dtos.ConsumerTransactionListDTO;
import gov.municipal.suda.service.LeaseConsumerDemandService;
import gov.municipal.suda.service.LeaseTransactionMasterService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/consumers")
public class ConsumerDemandController {
	@Autowired
	private LeaseConsumerDemandService leaseDemandService;
	
	
	@Autowired
	private LeaseTransactionMasterService leaaseTransactionMstr;
	
	@GetMapping("/consumer-mstr-id")
	public ConsumerDemandList getConsumerDemandList(@RequestParam("consumer_mstr_id") Long consumer_mstr_id) {
		
		return leaseDemandService.getAllDemandByConsumerMstrId(consumer_mstr_id);
	}

	@GetMapping("/consumer-mstr-id/transactions")
	public List<ConsumerTransactionListDTO> getTransactionList(@RequestParam("consumer_mstr_id") Long consumer_mstr_id) {
		
		return  leaaseTransactionMstr.getAllTrnsactionByConsumerMstrId(consumer_mstr_id);
	}
	@GetMapping("/demand_report_by_payment_mode_wise")
	 public ResponseEntity<?> getCollectionByPayMode(
	            @RequestParam("date_from") String date_from,
	            @RequestParam("date_to") String date_to,
	            @RequestParam("ward_id")String ward_id
	          
	    ){
	        return ResponseEntity.ok(leaseDemandService.getCollectionByPayMode(date_from,date_to, ward_id));
	     }
	
	@GetMapping({"/getCollectionByTeamWise"})
	  
    public ResponseEntity<?> getSummaryDataofUser(
    		@RequestParam("date_from") String date_from,
            @RequestParam("date_to") String date_to,@RequestParam("user_id")String user_id)
    // user_id = All, 1,2,3,4,.... etc
    {
    
    	return ResponseEntity.ok(leaseDemandService.getCollectionByTeamWise(date_from,date_to,user_id));
    	
    }
	

}
