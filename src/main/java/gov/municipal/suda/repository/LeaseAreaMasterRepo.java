package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseAreaMaster;

@Repository
public interface LeaseAreaMasterRepo extends JpaRepository<LeaseAreaMaster, Long> {

}
