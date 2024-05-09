package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseCollectionMaster;

@Repository
public interface LeaseCollectionMasterRepo extends JpaRepository<LeaseCollectionMaster, Long> {

}
