package gov.municipal.suda.model;



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
@Table(name = "tbl_lease_consumer_dmd")
public class LeaseConsumerDemand {
	@Id
    private Long id;
    private Long demand_no;
    private Long consumer_mstr_id;
    private Long ward_id;
    private Long demand_amount;
    private int payment_status;
    private Long penalty;
    private String fy_year;
    private Long fy_id;
    private Long last_payment_id;
    private Timestamp stampdate;
    private int status;

}
