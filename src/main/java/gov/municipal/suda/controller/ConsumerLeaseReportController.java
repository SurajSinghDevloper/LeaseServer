package gov.municipal.suda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.municipal.suda.dtos.GetCounterCollectionReportDTO;
import gov.municipal.suda.service.LeaseConsumerDemandService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/consumers")
public class ConsumerLeaseReportController {

	@Autowired 
	private LeaseConsumerDemandService leaseDemandSerivce;
	
	
	@GetMapping({"/lease/get_counter_collection_report"})
//    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN', 'PM', 'APM')")
    public ResponseEntity<?> getCounterCollectionReport(
            @RequestParam("date_from") String date_from,
            @RequestParam("date_to") String date_to,
            @RequestParam("ward_id") String ward_id,
            @RequestParam("user_id") String user_id,	            
            @RequestParam("payment_mode") String payment_mode
          
    ){
		ResponseEntity<List<GetCounterCollectionReportDTO>> responseEntity;

		if (date_from != null && date_to != null && ward_id != null && user_id != null && payment_mode != null) {
		    responseEntity = ResponseEntity.ok(leaseDemandSerivce.getCounterCollectionReport(date_from, date_to, ward_id, user_id, payment_mode));
		} else {
		    // Handle the case when any of the parameters is null
		    responseEntity = ResponseEntity.badRequest().build();
		}

		return responseEntity;

     }
}
