package com.bhiali_lease.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "tbl_lease_advance")
public class LeaseAdvance {
	@Id
    private Long id;
    private Long ward_id;
    private Long consumer_mstr_id;
    private Long trans_id;
    private BigDecimal amount;
    private String advance_type;
    private String file_name;
    private String remarks;
    private String reason;
    private int status;
    private Long user_id;
    private Date stampdate;
}
