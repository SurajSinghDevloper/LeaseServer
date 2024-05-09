package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gov.municipal.suda.model.LeaseUsageType;

public interface LeaseUsageTypeRepo  extends JpaRepository<LeaseUsageType, Integer>{

	@Query(value = "select * from tbl_usage_types where usage_id = :id", nativeQuery = true)
	public LeaseUsageType useOfLandData(Long id);


	
}
