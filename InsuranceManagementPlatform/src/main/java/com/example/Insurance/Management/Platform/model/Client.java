package com.example.Insurance.Management.Platform.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateOfBirth;
	
	@Column
    private String address;
	
	@Column
    private String contactInformation;
	
}
