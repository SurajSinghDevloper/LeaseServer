package gov.municipal.suda.model;

import java.math.BigDecimal;
//import java.security.Timestamp;

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
@Table(name = "tbl_lease_transaction_mstr")
public class LeaseTransactionMaster {
	@Id
    private Long id;
    private Long consumer_mstr_id;
    private Long ulb_id;
    private Long ward_id;
    private String trans_no;
    private String gst_no;
    private Date trans_date;
    private BigDecimal penalty;
    private BigDecimal discount;
    private BigDecimal demand_amt;
    private BigDecimal gst_amount;
    private BigDecimal payable_amt;
    private Long cash_verify_id;
    private Date cash_verify_date;
    private Long cash_verify_status;
    private Long cancel_status;
    private String ip_address;
    private String payment_mode;
    private String gst_doc;
    private String remarks;
    private Long user_id;
    private Timestamp stampdate;
    private Integer status;
    private BigDecimal prev_gst;
    private String prev_gst_doc;
    private BigDecimal kshati_purti;
    private String kshati_purti_doc;
    private String kp_from_year;
    private String kp_upto_year;

}
