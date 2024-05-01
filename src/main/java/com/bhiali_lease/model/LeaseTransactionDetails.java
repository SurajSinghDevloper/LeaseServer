package com.bhiali_lease.model;

import java.math.BigDecimal;
import java.sql.Date;
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
@Table(name = "tbl_lease_transaction_dtl")
public class LeaseTransactionDetails {
	@Id
    private Long id;
    private Long trans_mstr_id;
    private Long consumer_mstr_id;
    private String bank;
    private String branch;
    private String cheque_dd_neft_no;
    private Date cheque_dd_neft_date;
    private String card_type;
    private String card_holder_name;
    private Long card_no;
    private BigDecimal amount;
    private int cheque_status;
    private Date reconcile_date;
    private Long cleared_by;
    private Timestamp cleared_stampdate;
    private String reason;
    private BigDecimal bounce_amt;
    private int status;

}
