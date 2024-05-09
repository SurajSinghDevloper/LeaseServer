package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseTransactionDetails;

@Repository
public interface LeaseTranctionDetailsRepo extends JpaRepository<LeaseTransactionDetails, Long> {

}
