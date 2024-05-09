package gov.municipal.suda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.municipal.suda.model.ConsumerAllDropDownBean;
import gov.municipal.suda.service.ConsumerAllDropDownService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/consumers")
public class ConsumerAllDropDown {
	
	@Autowired
	private ConsumerAllDropDownService consumerAllDropDownService;
	
	@GetMapping("/allDropDown")
	public ResponseEntity<Optional<ConsumerAllDropDownBean>> getAllDropDownList() {
        return ResponseEntity.ok(consumerAllDropDownService.findAllDropDown());
    }

}
