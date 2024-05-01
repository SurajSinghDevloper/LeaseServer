package com.bhiali_lease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhiali_lease.model.LeaseTransactionMaster;

@Repository
public interface LeaseTransactionMasterRepo extends JpaRepository<LeaseTransactionMaster, Long> {

}
