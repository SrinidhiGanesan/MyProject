package com.example.Insurance.Management.Platform.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class InsurancePolicy {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
    private String policyNumber;
	
	@Column
    private String type;
	
	@Column
    private double coverageAmount;
	
	@Column
    private double premium;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startDate;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endDate;




	

}
