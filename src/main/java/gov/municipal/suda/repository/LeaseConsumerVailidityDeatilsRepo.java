package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseConsumerValidityDetails;

@Repository
public interface LeaseConsumerVailidityDeatilsRepo extends JpaRepository<LeaseConsumerValidityDetails, Long> {

}
