package gov.municipal.suda.serviceImpl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.municipal.suda.dtos.ConsumerAllDetailsDto;
import gov.municipal.suda.dtos.ConsumerBasicDtlsDTO;
import gov.municipal.suda.model.LeaseAreaMaster;
import gov.municipal.suda.model.LeaseConsumerDetails;
import gov.municipal.suda.model.LeaseConsumerMaster;
import gov.municipal.suda.model.LeaseUsageType;
import gov.municipal.suda.repository.LeaseAreaMasterRepo;
import gov.municipal.suda.repository.LeaseConsumerDetailsRepo;
import gov.municipal.suda.repository.LeaseConsumerMasterRepo;
import gov.municipal.suda.repository.LeaseUsageTypeRepo;
import gov.municipal.suda.service.LeaseConsumerMasterService;


@Service

public class LeaseConsumerMasterServiceImpl implements LeaseConsumerMasterService {

	 @Autowired
	    private LeaseConsumerMasterRepo consumerRepo;

	    @Autowired
	    private LeaseConsumerDetailsRepo consumerDtlRepo;
	    
	    @Autowired
	    private LeaseAreaMasterRepo areaRepo;
	    
	    @Autowired
	    private LeaseUsageTypeRepo leaseRepo;
	    
	    
	    @Override
	    public Page<ConsumerBasicDtlsDTO> allConsumerBasicDetails(int page, int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        Page<LeaseConsumerMaster> leaseConsumerMasters = consumerRepo.findAll(pageable);

	        return leaseConsumerMasters.map(cm -> {
	            ConsumerBasicDtlsDTO cbd = new ConsumerBasicDtlsDTO();
	            cbd.setWardNo(cm.getWard_id());
	            cbd.setConsumerNo(cm.getId().toString());
	            cbd.setAddress(cm.getAddress());
	            cbd.setArea(cm.getArea());
	            cbd.setUsesType(cm.getUseof_land());
	            cbd.setAmt(cm.getLease_amnt());
	            cbd.setStartDate(cm.getLease_date());
	            cbd.setEndDate(cm.getLease_end_date());
	            cbd.setStatus(cm.getStatus());

	            // Fetch LeaseConsumerDetails by consumer_mstr_id
	            LeaseConsumerDetails details = consumerDtlRepo.findByConsumer_mstr_id(cm.getId());
	            if (details != null) {
	                cbd.setConsumerName(details.getConsumer_name());
	                cbd.setContactNo(details.getMob_no());
	            }

	            return cbd;
	        });
	    }
	    
	    @Override
	    public ConsumerAllDetailsDto getDetails(String leasaeNo) {
	    	ConsumerAllDetailsDto data = new ConsumerAllDetailsDto();
	    	
	    	LeaseConsumerMaster cm = consumerRepo.findByLeaseno(leasaeNo);

	    	LeaseConsumerDetails cd = consumerDtlRepo.findByConsumer_mstr_id(cm.getId());
	    	data.setWard_id(cm.getWard_id());
	    	data.setConsumerID(cm.getId());
	    	data.setConsumerName(cd.getConsumer_name());
	    	data.setGurdianName(cd.getFathers_name());
	    	data.setMobileNo(cd.getMob_no());
	    	data.setRelation(cd.getRelation());
	    	data.setEmailId(cd.getEmail());
	    	data.setAddress(cd.getCorres_address());
	    	data.setLeaseNo(cm.getLease_no());
	    	LeaseAreaMaster area = areaRepo.findById(cm.getArea_id()).get();
	    	data.setLeaseArea(area.getArea_addr());
	    	Long useLand = cm.getUseof_land();
	    	LeaseUsageType useOfLand = leaseRepo.useOfLandData(useLand);
	    	data.setUsesOfLand(useOfLand.getUsage_name());
	    	data.setPlotAddress(cm.getAddress());
	    	 SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    	 SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	    	 String inputDateStrStart= cm.getLease_date();
	    	 String inputDareStrEnd = cm.getLease_end_date();
	    	 Date inputDateStart;
	    	 Date inputDateEnd;
	    	 String outputDateStrStart="";
	    	 String outputDateStrEnd="";
			try {
				inputDateStart = inputDateFormat.parse(inputDateStrStart);
				outputDateStrStart = outputDateFormat.format(inputDateStart);
				
				inputDateEnd= inputDateFormat.parse(inputDareStrEnd);
				outputDateStrEnd = outputDateFormat.format(inputDateEnd);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 	
	    	data.setLeaseStartDate(outputDateStrStart);
	    	data.setLeaseEndDate(outputDateStrEnd);
	    	double Area = cm.getWidth() * cm.getLength();
	    	float totalArea = (float) Area;
	    	data.setTotalArea(totalArea);
	    	data.setAreaDimension("W "+cm.getWidth()+" mtrs "+"x"+" L "+cm.getLength()+" mtrs");
	    	data.setLeaseAmt(cm.getLease_amnt());
	    	
	    	
	    	return data;
	    }
}
