package gov.municipal.suda.service;





import java.util.List;

import gov.municipal.suda.dtos.ConsumerDemandList;
import gov.municipal.suda.dtos.GetCounterCollectionReportDTO;
import gov.municipal.suda.dtos.LeasePaymentModeReport;
import gov.municipal.suda.dtos.TeamWiseCollectionReport;



public interface LeaseConsumerDemandService {

	 ConsumerDemandList getAllDemandByConsumerMstrId(Long consumer_mstr_id);

	 List<GetCounterCollectionReportDTO> getCounterCollectionReport(String date_from, String date_to, String ward_id, String user_id,
			String payment_mode);

	List<LeasePaymentModeReport> getCollectionByPayMode(String date_from, String date_to,String ward_id);

	List<TeamWiseCollectionReport> getCollectionByTeamWise(String date_from, String date_to, String user_id);

	List<Object[]> getCurrentArrearModuleCollectionReport(String date_from, String date_to, String ward_id);

}
