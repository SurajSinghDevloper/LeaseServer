package gov.municipal.suda.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseTransactionMaster;

@Repository
public interface LeaseTransactionMasterRepo extends JpaRepository<LeaseTransactionMaster, Long> {

	
	@Query(value="select tltm.trans_no,tltm.trans_date,tltm.payment_mode,tltm.payable_amt,tltm.user_id from tbl_lease_transaction_mstr tltm where tltm.consumer_mstr_id=:consumer_mstr_id and status=1 ",nativeQuery=true)
	List<Object[]> getTrsanactionByConsumerMstrId(@Param("consumer_mstr_id")Long consumer_mstr_id);
	
	
		@Query(value = "SELECT user_id, COUNT(DISTINCT consumer_mstr_id) AS consumer_count, " +
				"SUM(payable_amt) AS total_payable_amt " +
				"FROM tbl_lease_transaction_mstr " +
				"WHERE trans_date BETWEEN :startDate AND :endDate " +
				"AND (:userId = 0 OR user_id = :userId) " +
				"GROUP BY user_id", nativeQuery = true)
		List<Object[]> getUserTransactionSummary(@Param("startDate") Date startDate, @Param("endDate") Date endDate,@Param("userId") Long userId
		);

}
