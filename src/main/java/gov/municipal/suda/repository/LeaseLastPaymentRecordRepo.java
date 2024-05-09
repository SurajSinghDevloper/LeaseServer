package gov.municipal.suda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.municipal.suda.model.LeaseLastPaymentRecord;

@Repository
public interface LeaseLastPaymentRecordRepo extends JpaRepository<LeaseLastPaymentRecord, Long> {

}
