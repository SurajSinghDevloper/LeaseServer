package gov.municipal.suda.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.municipal.suda.dtos.ConsumerDemandListDTO;
import gov.municipal.suda.dtos.ConsumerTransactionListDTO;
import gov.municipal.suda.repository.LeaseConsumerDemandRepo;
import gov.municipal.suda.repository.LeaseTransactionMasterRepo;
import gov.municipal.suda.service.LeaseTransactionMasterService;

@Service
public class LeaseTransactionMasterServiceImpl implements LeaseTransactionMasterService {

	@Autowired
	private LeaseTransactionMasterRepo leaseTransactionMasterRepo;
	@Autowired
	private LeaseConsumerDemandRepo leaseConsumerDemandRepo;
	
	@Override
	public List<ConsumerTransactionListDTO> getAllTrnsactionByConsumerMstrId(Long consumer_mstr_id) {
		
		List<ConsumerTransactionListDTO> resultList = new ArrayList<>();
		List<Object[]> result = leaseTransactionMasterRepo.getTrsanactionByConsumerMstrId(consumer_mstr_id);
		List<ConsumerDemandListDTO> demandList = new ArrayList<>();
		
		List<Object[]> dtoList = leaseConsumerDemandRepo.getDemandByConsumermstrId(consumer_mstr_id);
		
		for(Object[] dto: result) {
			ConsumerTransactionListDTO listDto = new ConsumerTransactionListDTO();
			listDto.setTransactionNo(dto[0].toString());
			listDto.setTransactionDate(dto[1].toString());
			listDto.setPaymentMode(dto[2].toString());
			listDto.setPayableAmount((BigDecimal) dto[3]);
			Long userId = (Long) dto[4];
			// need to work when join the main Spring Boot Project from UserDetails Table
			
			// Assuming fy_year is the first element in the array
			String demand_from = (String) dtoList.get(0)[0];
			String demand_to = (String) dtoList.get(dtoList.size() - 1)[0];

			listDto.setFromYear(demand_from);
			listDto.setUptoYear(demand_to);
			
			
			
			
			resultList.add(listDto);
		}
		
		
		
		
		return resultList;
	}

}
