package com.bhiali_lease.model;

import java.sql.Date;

import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "tbl_lease_area_mstr")
public class LeaseAreaMaster {
	@Id
    private Long id;
	private String area_addr;
    private int status;
    private Long userid;
    private Date stampDate;
}
