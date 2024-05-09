package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseTransctionAdvance;

@Repository
public interface LeaseTransactionAdvanceRepo extends JpaRepository<LeaseTransctionAdvance, Long> {

}
