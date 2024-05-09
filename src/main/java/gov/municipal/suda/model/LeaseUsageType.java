package gov.municipal.suda.model;

import java.math.BigDecimal;


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
@Table(name = "tbl_usage_types")
public class LeaseUsageType {
	@Id
	private Integer usage_id;
	private String usage_name;
	private String description;
	private BigDecimal usage_type_interest_rate;
	private Integer status;

}
