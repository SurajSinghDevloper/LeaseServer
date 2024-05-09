package gov.municipal.suda.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "tbl_lease_last_payment_record")
public class LeaseLastPaymentRecord {
	@Id
    private Long id;
    private Long consumer_mstr_id;
    private String receipt_no;
    private Date receipt_date;
    private String book_no;
    private String recpt_filename;
    private Long user_id;
    private Date entry_date;
    private Time time;
    private String frm_year;
    private String upto_year;
    private int tot_amount;
    private int fine_amount;

}
