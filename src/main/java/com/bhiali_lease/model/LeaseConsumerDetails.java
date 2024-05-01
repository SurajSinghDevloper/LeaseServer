package com.bhiali_lease.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "tbl_lease_consumer_dtl")
public class LeaseConsumerDetails {
	@Id
    private Long id;
    private Long consumer_mstr_id;
    private String consumer_name;
    private String fathers_name;
    private String email;
    private String corres_address;
    private Long mob_no;
    private Long corres_pincode;
    private Long user_id;
    private int status;
    private Timestamp stampdate;
    private String relation;

}
