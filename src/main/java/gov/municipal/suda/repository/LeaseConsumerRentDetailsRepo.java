package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseConsumerRentDetails;

@Repository
public interface LeaseConsumerRentDetailsRepo extends JpaRepository<LeaseConsumerRentDetails, Long> {

}
