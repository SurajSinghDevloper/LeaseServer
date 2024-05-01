package com.bhiali_lease.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_fy")
@Data
@Getter
@Setter
@Entity
public class FinancialYear {
	@Id
    private Long id;
    private String fy_name;
    private int status;
}
