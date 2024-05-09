package gov.municipal.suda.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseConsumerDemand;

@Repository
public interface LeaseConsumerDemandRepo extends JpaRepository<LeaseConsumerDemand, Long> {

	@Query(value = "SELECT tlcd.fy_year, tlcd.demand_amount, tlcd.penalty FROM tbl_lease_consumer_dmd tlcd WHERE tlcd.consumer_mstr_id = :consumerMstrId and tlcd.payment_status=1", nativeQuery = true)
	public List<Object[]> getDemandByConsumermstrId(Long consumerMstrId);

@Query(value = "SELECT * FROM lease_payment_mode_report WHERE latest_verify_date BETWEEN :startDate AND :endDate AND cash_verify_status = 1 AND (:wardId = 0 OR ward_id = :wardId)", nativeQuery = true)
List<Object[]> findByDateRangeAndCashVerifyStatusAndWardId(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("wardId") Long wardId);

@Query("SELECT lcd FROM tbl_lease_consumer_dmd lcd " +
        "WHERE lcd.stampdate BETWEEN :startDate AND :endDate " +
        "AND (:wardId = 0 OR lcd.wardId = :wardId)")
 List<Object[]> findByStampdateAndWardIdBetween(@Param("startDate") Date startDate,
                                                         @Param("endDate") Date endDate,
                                                         @Param("wardId") Long wardId);
	
}
