package gov.municipal.suda.repository;


import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseConsumerMaster;

@Repository
public interface LeaseConsumerMasterRepo extends JpaRepository<LeaseConsumerMaster, Long> {
	@Query(value = "SELECT * FROM tbl_lease_consumer_mstr", nativeQuery = true)
	public List<LeaseConsumerMaster> findByAll();
	
	   @Query(value = "SELECT * FROM tbl_lease_consumer_mstr as tlcm WHERE tlcm.lease_no = :leaseNo", nativeQuery = true)
	    public LeaseConsumerMaster findByLeaseno(@Param("leaseNo") String leaseNo);
	
	   @Query(value = "SELECT * FROM lease_get_counter_collection_report WHERE transaction_date BETWEEN :startDate AND :endDate" +
               " AND (:wardId = 0 OR ward_id = :wardId)" +
               " AND (:userId = 0 OR user_id = :userId)" +
               " AND (:paymentMode = '' OR payment_mode = :paymentMode)",
       nativeQuery = true)
public List<Object[]> findByTransactionDateAndWardIdAndUserIdAndPaymentMode(@Param("startDate") Date startDate,
                                                                             @Param("endDate") Date endDate,
                                                                             @Param("wardId") BigInteger wardId,
                                                                             @Param("userId") BigInteger userId,
                                                                             @Param("paymentMode") String paymentMode);




}
