package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.FinancialYear;

@Repository
public interface FinancialYearRepo extends JpaRepository<FinancialYear, Long> {

}
