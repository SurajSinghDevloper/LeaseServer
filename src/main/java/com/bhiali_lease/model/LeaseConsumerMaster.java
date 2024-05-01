package com.bhiali_lease.model;

import java.math.BigDecimal;
import java.security.Timestamp;

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
@Table(name = "tbl_lease_consumer_mstr")
public class LeaseConsumerMaster {
	@Id
    private Long id;
    private Long consumer_lease_no;
    private Long area_id;
    private Long ward_id;
    private int pin_code;
    private String lease_no;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal area;
    private String address;
    private BigDecimal lease_amnt;
    private int useof_land;
    private String lease_date;
    private String lease_end_date;
    private Long lease_status;
    private int status;
    private Long user_id;
    private Timestamp stampdate;
    private int diff_status;
    private String doc_upload;
    private Long lastupdateby;
    private Timestamp lastupdateentrydatetime;

}
