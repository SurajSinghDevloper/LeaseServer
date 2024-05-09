package gov.municipal.suda.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_lease_collection_mstr")
public class LeaseCollectionMaster {
	@Id
    private Long id;
    private Long ward_id;
    private Long consumer_mstr_id;
    private Long demand_id;
    private Long trans_mstr_id;
    private BigDecimal demand_amount;
    private BigDecimal penalty;
    private String fy_year;
    private Long fy_id;
    private Long user_id;
    private Timestamp stampdate;
    private int status;

}
