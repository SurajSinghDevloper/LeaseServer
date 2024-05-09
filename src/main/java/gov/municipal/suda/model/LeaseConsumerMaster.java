package gov.municipal.suda.model;

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
@Table(name = "tbl_lease_consumer_mstr")
public class LeaseConsumerMaster {
	@Id
    private Long id;
    private Long consumer_lease_no;
    private Long area_id;
    private Long ward_id;
    private Long pin_code;
    private String lease_no;
    private Double length;
    private Double width;
    private Double area;
    private String address;
    private Double lease_amnt;
    private Long useof_land;
    private String lease_date;
    private String lease_end_date;
    private Long lease_status;
    private Long status;
    private Long user_id;
    private Timestamp stampdate;
    private Long diff_status;
    private String doc_upload;
    private Long lastupdateby;
    private Timestamp lastupdateentrydatetime;

}
