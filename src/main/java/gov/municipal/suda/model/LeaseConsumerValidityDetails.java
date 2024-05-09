package gov.municipal.suda.model;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "tbl_lease_consumer_validity_dtl")
public class LeaseConsumerValidityDetails {
	@Id
    private Long id;
    private Long consumer_mstr_id;
    private Date lease_date;
    private Date lease_expiry_date;
    private Long lease_fy_id;
    private int status;
    private Long user_id;
    private Timestamp stampdate;

}
