package com.bhiali_lease.model;

import java.math.BigDecimal;
import java.sql.Date;

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
@Table(name = "tbl_lease_consumer_rent_dtls")
public class LeaseConsumerRentDetails {
	@Id
    private Long id;
    private Long consumer_mstr_id;
    private BigDecimal yearly_amount;
    private Date effect_date;
    private Long fy_id;
    private Long user_id;
    private Date stamdate;

}
