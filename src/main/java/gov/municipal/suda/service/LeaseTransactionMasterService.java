package gov.municipal.suda.service;

import java.util.List;

import gov.municipal.suda.dtos.ConsumerTransactionListDTO;

public interface LeaseTransactionMasterService {

	List<ConsumerTransactionListDTO> getAllTrnsactionByConsumerMstrId(Long consumer_mstr_id);

}
