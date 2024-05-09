package com.bhiali_lease.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.bhiali_lease.dtos.ConsumerBasicDtlsDTO;
import com.bhiali_lease.model.LeaseConsumerDetails;
import com.bhiali_lease.model.LeaseConsumerMaster;
import com.bhiali_lease.repository.LeaseConsumerDetailsRepo;
import com.bhiali_lease.repository.LeaseConsumerMasterRepo;
import com.bhiali_lease.service.LeaseConsumerMasterService;

@Service
public class LeaseConsumerMasterServiceImpl implements LeaseConsumerMasterService {

	@Autowired
	private LeaseConsumerMasterRepo consumerRepo;
	@Autowired
	private LeaseConsumerDetailsRepo consumerDtlRepo;
	
	
	@Override
	public List<ConsumerBasicDtlsDTO>allConsumerBasicDetails(){
		List<LeaseConsumerMaster> data = consumerRepo.findAll();
		List<ConsumerBasicDtlsDTO> newData = new ArrayList<>();
		for(LeaseConsumerMaster cm  :data) {
			LeaseConsumerDetails  cd = findConsumerDeatilsByID(cm.getId());
			ConsumerBasicDtlsDTO cbd = new ConsumerBasicDtlsDTO();
			cbd.setWardNo(cm.getWard_id());
			cbd.setConsumerNo(cm.getId().toString());
			cbd.setConsumerName(cd.getConsumer_name());
			cbd.setContactNo(cd.getMob_no());
			cbd.setAddress(cm.getAddress());
			cbd.setArea(cm.getArea());
			cbd.setUsesType(cm.getUseof_land());
			cbd.setAmt(cm.getLease_amnt());
			cbd.setStartDate(cm.getLease_date());
			cbd.setEndDate(cm.getLease_end_date());
			cbd.setStatus(cm.getStatus());
			newData.add(cbd);
			cbd=null;
		}
		return newData;
	}

	public LeaseConsumerDetails findConsumerDeatilsByID(Long id) {
		LeaseConsumerDetails deatails = consumerDtlRepo.findByConsumer_mstr_id(id);
		return deatails;
	}

}
