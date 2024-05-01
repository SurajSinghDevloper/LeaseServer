package com.bhiali_lease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhiali_lease.model.GSTMaster;

@Repository
public interface GSTMasterRepo extends JpaRepository<GSTMaster, Long> {

}
