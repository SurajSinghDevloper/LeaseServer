package gov.municipal.suda.serviceImpl;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.municipal.suda.dtos.ConsumerDemandList;
import gov.municipal.suda.dtos.ConsumerDemandListDTO;
import gov.municipal.suda.dtos.GetCounterCollectionReportDTO;
import gov.municipal.suda.dtos.LeasePaymentModeReport;
import gov.municipal.suda.dtos.TeamWiseCollectionReport;
import gov.municipal.suda.repository.LeaseConsumerDemandRepo;
import gov.municipal.suda.repository.LeaseConsumerMasterRepo;
import gov.municipal.suda.repository.LeaseTransactionMasterRepo;
import gov.municipal.suda.service.LeaseConsumerDemandService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LeaseConsumerDemandServiceImpl implements LeaseConsumerDemandService {
	
	@Autowired
	private LeaseConsumerDemandRepo leaseConsumerDemandRepo;
	
	@Autowired
	private LeaseConsumerMasterRepo leaseConsumerMstrRepo;
	
	@Autowired
	private LeaseTransactionMasterRepo leaseTransactionMstrRepo;
	

	@Override
	public ConsumerDemandList getAllDemandByConsumerMstrId(Long consumer_mstr_id) {
		
		List<ConsumerDemandListDTO> demandList = new ArrayList<>();
		
		List<Object[]> dtoList = leaseConsumerDemandRepo.getDemandByConsumermstrId(consumer_mstr_id);
		Long demandPayment=0L;
		for (Object[] dto : dtoList) {
		    ConsumerDemandListDTO consumerDto = new ConsumerDemandListDTO();
		    
		    consumerDto.setFy_year(dto[0].toString());
		    consumerDto.setDemand_amount((Long) dto[1]);
		    consumerDto.setPenalty((Long) dto[2]); 
		    // Convert the sum of demand_amount and penalty to Long
		    Long payableAmount = ((Long) dto[1]) + ((Long) dto[2]);
		    consumerDto.setPayable_amount(payableAmount);
		    demandList.add(consumerDto);
		    demandPayment =demandPayment+(Long) dto[1];
 
		}
		String demand_from = demandList.get(0).getFy_year();
		String demand_to= demandList.get(demandList.size()-1).getFy_year();
		ConsumerDemandList consumerDemandList= new ConsumerDemandList();
		consumerDemandList.setDemandList(demandList);
		consumerDemandList.setDemand_from(demand_from);
		consumerDemandList.setDemand_to(demand_to);
		consumerDemandList.setDemand_amount(demandPayment);
		
		return consumerDemandList;
	}

	@Override
	public List<GetCounterCollectionReportDTO> getCounterCollectionReport(String date_from, String date_to, String ward_id, String user_id,
			String payment_mode) {
		// TODO Auto-generated method stub
		BigInteger wardId;
		BigInteger userId;
		String paymentMode;

		if (ward_id.equals("all") && user_id.equals("all") && payment_mode.equals("all")) {
		    wardId = BigInteger.ZERO;
		    userId = BigInteger.ZERO;
		    paymentMode = "";
		} else {
		    wardId = new BigInteger(String.valueOf(ward_id));
		    userId = new BigInteger(String.valueOf(user_id));
		    paymentMode = payment_mode;
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate;
		Date fromDate =null ;
		Date toDate= null;
		try {
			utilDate = dateFormat.parse(date_from);
			 fromDate = new Date(utilDate.getTime());
			utilDate = dateFormat.parse(date_to);
			toDate = new Date(utilDate.getTime());
		} catch(ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Convert java.util.Date to java.sql.Date
        
		
		List<Object[]> resultList = leaseConsumerMstrRepo.findByTransactionDateAndWardIdAndUserIdAndPaymentMode(fromDate, toDate, wardId, userId, paymentMode);
		List<GetCounterCollectionReportDTO> counterReport = new ArrayList<>();
		
		for (Object[] dto : resultList) {
		    GetCounterCollectionReportDTO getReport = new GetCounterCollectionReportDTO();
		    getReport.setWardId(dto[0] != null ? (Long) dto[0] : null);
		    getReport.setLeaseNo(dto[1] != null ? dto[1].toString() : null);
		    getReport.setConsumerName(dto[2] != null ? dto[2].toString() : null);
		    getReport.setMobNo(dto[3] != null ? (Long) dto[3] : null);
		    getReport.setCorresAddress(dto[4] != null ? dto[4].toString() : null);
		    getReport.setAreaAddr(dto[5] != null ? dto[5].toString() : null);
		    getReport.setPaymentMode(dto[6] != null ? dto[6].toString() : null);
		    getReport.setDemandAmount(dto[7] != null ? (Long) dto[7] : null);
		    getReport.setTransNo(dto[8] != null ? dto[8].toString() : null);
		    getReport.setFirstFyYear(dto[9] != null ? dto[9].toString() : null);
		    getReport.setLastFyYear(dto[10] != null ? dto[10].toString() : null);
		    getReport.setTransactionDate(dto[11] != null ? (Date) dto[11] : null);
		    getReport.setBank(dto[12] != null ? dto[12].toString() : null);
		    getReport.setBranch(dto[13] != null ? dto[13].toString() : null);
		    getReport.setCardHolderName(dto[14] != null ? dto[14].toString() : null);
		    getReport.setCardNo(dto[15] != null ? dto[15].toString() : null);
		    getReport.setCardType(dto[16] != null ? dto[16].toString() : null);
		    getReport.setChequeDdNeftDate(dto[17] != null ? (Date)dto[17] : null);
		    getReport.setChequeDdNeftNo(dto[18] != null ?  dto[18].toString() : null);
		    getReport.setGstAmount(dto[19] != null ? (BigDecimal) dto[19] : null);
		    getReport.setUserId(dto[20] != null ? (Long) dto[20] : null);

		    counterReport.add(getReport);
		}

		
		
		
		
		return counterReport;
	}

	@Override
	public List<LeasePaymentModeReport> getCollectionByPayMode(String date_from, String date_to,String ward_id) {
	
		List<LeasePaymentModeReport> report = new ArrayList<>();
		Date fromDate=null;
		Date toDate=null;
		try {
			fromDate = convertStringToDate(date_from);
			toDate = convertStringToDate(date_to);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long wardId;
		if(ward_id.equals("All"))
			wardId= 0L;
		else
		 wardId = Long.parseLong(ward_id);
        
        
		List<Object[]> objecdto =  leaseConsumerDemandRepo.findByDateRangeAndCashVerifyStatusAndWardId(fromDate, toDate, wardId);
		
		Map<String, Long> totalCountMap = new HashMap<>();
		Map<String, BigDecimal> totalAmountMap = new HashMap<>();

		for (Object[] dto : objecdto) {
		    String paymentMode = (String) dto[17];
		    Long totalCount=0L;
		    BigDecimal totalAmount=BigDecimal.ZERO;
		    if(paymentMode.equals("CASH")) {
		     totalCount = (Long) dto[0];
		    totalAmount = (BigDecimal) dto[1];
		    }
		    if(paymentMode.equals("CHEQUE")) {
			     totalCount = (Long) dto[2];
			    totalAmount = (BigDecimal) dto[3];
			    }
		    
		    if(paymentMode.equals("CARD")) {
			     totalCount = (Long) dto[4];
			    totalAmount = (BigDecimal) dto[5];
			    }
		    if(paymentMode.equals("NEFT")) {
			     totalCount = (Long) dto[6];
			    totalAmount = (BigDecimal) dto[7];
			    }
		    if(paymentMode.equals("RTGS")) {
			     totalCount = (Long) dto[8];
			    totalAmount = (BigDecimal) dto[9];
			    }
		    if(paymentMode.equals("DD")) {
			     totalCount = (Long) dto[10];
			    totalAmount = (BigDecimal) dto[11];
			    }
		    if(paymentMode.equals("UPI")) {
			     totalCount = (Long) dto[12];
			    totalAmount = (BigDecimal) dto[13];
			    }
		    if (totalCount > 0) {
		    	totalCountMap.put(paymentMode, totalCountMap.getOrDefault(paymentMode, 0L) + 1);
		        totalAmountMap.put(paymentMode, totalAmountMap.getOrDefault(paymentMode, BigDecimal.ZERO).add(totalAmount));
		    }
		}
		

		// Create and populate LeasePaymentModeReport objects
		for (Map.Entry<String, Long> entry : totalCountMap.entrySet()) {
		    String paymentMode = entry.getKey();
		    Long totalCount = entry.getValue();
		    BigDecimal totalAmount = totalAmountMap.get(paymentMode);

		    LeasePaymentModeReport leaseReport = new LeasePaymentModeReport();
		    leaseReport.setPayment_mode(paymentMode);
		    leaseReport.setTotal_count(totalCount);
		    leaseReport.setTotal_amt(totalAmount);

		    report.add(leaseReport);
		}	
		
		return report;
	}

	public static Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = format.parse(dateString);
        return new Date(utilDate.getTime());
    }

	@Override
	public List<TeamWiseCollectionReport> getCollectionByTeamWise(String date_from, String date_to, String user_id) {
		Date fromDate=null;
		Date toDate=null;
		try {
			fromDate = convertStringToDate(date_from);
			toDate = convertStringToDate(date_to);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long userId;
		if(user_id.equals("All"))
			userId= 0L;
		else
			userId = Long.parseLong(user_id);
		List<TeamWiseCollectionReport> teamReport = new ArrayList<>();
		List<Object[]> objectDto= leaseTransactionMstrRepo.getUserTransactionSummary(fromDate, toDate, userId);
		for(Object[]dto:objectDto) {
			TeamWiseCollectionReport teamwiseReport = new TeamWiseCollectionReport();
			teamwiseReport.setUser_id( (Long) dto[0]);
			teamwiseReport.setCollector_name("Not Available");
			teamwiseReport.setCollector_type("Not Avaialble");
			teamwiseReport.setTotal_applicant((Long) dto[1]);
			teamwiseReport.setTotal_collections((BigDecimal) dto[2]);
			teamReport.add(teamwiseReport);
			
		}
		
		return teamReport;
	}
}
