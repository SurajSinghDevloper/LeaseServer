package com.bhiali_lease.model;

import java.math.BigDecimal;

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
@Table(name = "tbl_lease_trans_advance")
public class LeaseTransctionAdvance {
	@Id
    private Long id;
    private Long ward_id;
    private Long consumer_mstr_id;
    private Long transaction_id;
    private Long advance_id;
    private BigDecimal amount;
    private int status;

}
