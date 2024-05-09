package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseAdvance;

@Repository
public interface LeaseAdvanceRepo extends JpaRepository<LeaseAdvance, Long> {

}
