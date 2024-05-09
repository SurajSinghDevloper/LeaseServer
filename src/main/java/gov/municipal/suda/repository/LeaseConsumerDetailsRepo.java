package gov.municipal.suda.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseConsumerDetails;

@Repository
public interface LeaseConsumerDetailsRepo extends JpaRepository<LeaseConsumerDetails, Long> {

    @Query(value = "SELECT * FROM tbl_lease_consumer_dtl WHERE consumer_mstr_id = ?1", nativeQuery = true)
	public LeaseConsumerDetails findByConsumer_mstr_id(Long id);
	
//	@Query(value = "SELECT * FROM tbl_lease_consumer_dtl WHERE consumer_mstr_id IN ?1", nativeQuery = true)
//	LeaseConsumerDetails findByConsumer_mstr_id(Long ids);
}
