package com.bhiali_lease.model;

import java.sql.Date;

import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "tbl_lease_transaction_deactive")
public class LeaseTransctionDeactivate {
	@Id
    private Long id;
    private Long trans_mstr_id;
    private Long consumer_mstr_id;
    private Long ward_id;
    private Long user_id;
    private Date stampdate;
    private String reason;
    private String document;
}
