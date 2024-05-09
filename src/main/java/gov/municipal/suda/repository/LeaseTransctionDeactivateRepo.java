package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseTransctionDeactivate;

@Repository
public interface LeaseTransctionDeactivateRepo extends JpaRepository<LeaseTransctionDeactivate, Long> {

}
