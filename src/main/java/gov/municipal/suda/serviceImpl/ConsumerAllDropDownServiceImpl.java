package gov.municipal.suda.serviceImpl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.municipal.suda.model.ConsumerAllDropDownBean;
import gov.municipal.suda.repository.FinancialYearRepo;
import gov.municipal.suda.repository.GSTMasterRepo;
import gov.municipal.suda.repository.LeaseAreaMasterRepo;
import gov.municipal.suda.service.ConsumerAllDropDownService;

@Service
public class ConsumerAllDropDownServiceImpl implements ConsumerAllDropDownService {

	@Autowired
	private FinancialYearRepo financial_year;
	
	@Autowired
	private GSTMasterRepo gstMstrRepo;
	
	@Autowired
	private LeaseAreaMasterRepo leaseAreaMasterRepo;
	
	
	
	@Override
	public Optional<ConsumerAllDropDownBean> findAllDropDown() {
		// TODO Auto-generated method stub
		ConsumerAllDropDownBean consumerDropDown = new ConsumerAllDropDownBean();
		consumerDropDown.setGstMaster(gstMstrRepo.findAll().stream().collect(Collectors.toList()));
		consumerDropDown.setFyYear(financial_year.findAll().stream().collect(Collectors.toList()));
		consumerDropDown.setAreaMaster(leaseAreaMasterRepo.findAll().stream().collect(Collectors.toList()));
		
		return Optional.of(consumerDropDown);
	}

}
