package com.bhiali_lease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhiali_lease.model.LeaseLastPaymentRecord;

@Repository
public interface LeaseLastPaymentRecordRepo extends JpaRepository<LeaseLastPaymentRecord, Long> {

}
