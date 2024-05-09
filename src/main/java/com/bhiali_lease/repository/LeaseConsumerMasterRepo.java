package com.bhiali_lease.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bhiali_lease.model.LeaseConsumerMaster;

@Repository
public interface LeaseConsumerMasterRepo extends JpaRepository<LeaseConsumerMaster, Long> {
//	   @Query(value = "SELECT "
//	            + "cm.id AS consumer_master_id, "
//	            + "cm.address AS consumer_address, "
//	            + "cm.area, "
//	            + "cm.area_id, "
//	            + "cm.consumer_lease_no, "
//	            + "cm.diff_status, "
//	            + "cm.doc_upload, "
//	            + "cm.lastupdateby, "
//	            + "cm.lastupdateentrydatetime, "
//	            + "cm.lease_amnt, "
//	            + "cm.lease_date, "
//	            + "cm.lease_end_date, "
//	            + "cm.lease_no, "
//	            + "cm.lease_status, "
//	            + "cm.length, "
//	            + "cm.pin_code AS consumer_pincode, "
//	            + "cm.stampdate AS consumer_stampdate, "
//	            + "cm.status AS consumer_status, "
//	            + "cm.useof_land, "
//	            + "cm.user_id AS consumer_user_id, "
//	            + "cm.ward_id, "
//	            + "cd.id AS consumer_detail_id, "
//	            + "cd.consumer_mstr_id, "
//	            + "cd.consumer_name, "
//	            + "cd.corres_address AS correspondence_address, "
//	            + "cd.corres_pincode AS correspondence_pincode, "
//	            + "cd.email, "
//	            + "cd.fathers_name, "
//	            + "cd.mob_no AS mobile_number, "
//	            + "cd.relation, "
//	            + "cd.stampdate AS detail_stampdate, "
//	            + "cd.status AS detail_status, "
//	            + "cd.user_id AS detail_user_id "
//	            + "FROM tbl_lease_consumer_mstr AS cm "
//	            + "JOIN tbl_lease_consumer_dtl AS cd ON cm.id = cd.consumer_mstr_id", nativeQuery = true)
//	    List<Object[]> findAllLeaseConsumerDetails();
}
