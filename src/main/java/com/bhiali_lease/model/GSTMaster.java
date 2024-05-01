package com.bhiali_lease.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_gst_mstr")
@Entity
@Getter
@Setter
@Data
public class GSTMaster {
	@Id
    private Long id;
    private String tax_head;
    private double gst_per;
    private Long fy_id;
    private Date doe;
    private int status;
    private Date stampdate;
    private Long user_id;

}
