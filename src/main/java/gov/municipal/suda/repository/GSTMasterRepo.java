package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.GSTMaster;

@Repository
public interface GSTMasterRepo extends JpaRepository<GSTMaster, Long> {

}
