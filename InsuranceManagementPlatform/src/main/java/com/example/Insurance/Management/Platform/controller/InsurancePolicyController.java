package com.example.Insurance.Management.Platform.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Insurance.Management.Platform.model.InsurancePolicy;
import com.example.Insurance.Management.Platform.service.InsurancePolicyService;



@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {
	@Autowired
	private InsurancePolicyService insurancePolicyService;

	public InsurancePolicyController(InsurancePolicyService insurancePolicyService) {
		super();
		this.insurancePolicyService = insurancePolicyService;
	}
	
	//Add values
	//api/policies
	@PostMapping
	  public ResponseEntity<InsurancePolicy>saveInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy){
		
		return new ResponseEntity<InsurancePolicy>(insurancePolicyService.saveInsurancePolicy(insurancePolicy),HttpStatus.CREATED);
	}
	
	//Retrieve all the data
	
	 @GetMapping
	   public List<InsurancePolicy>getAllInsurancePolicy(){
		   return insurancePolicyService.getAllinsurancePolicy();
	   }
	
   
	 //Retrieve data by id
	 //api/clients/id
	 
	 @GetMapping("{id}")
		public ResponseEntity<InsurancePolicy>getInsurancePolicyById(@PathVariable("id")long insurancePolicy){
			return new ResponseEntity<InsurancePolicy>(insurancePolicyService.getInsurancePolicyById(insurancePolicy),HttpStatus.OK);
	 }
	 
	
	//update client
	 //api/clients/id
	 
	   @PutMapping("{id}")
	   public ResponseEntity<InsurancePolicy>updateInsurancePolicytById(@PathVariable("id")long id,@RequestBody InsurancePolicy insurancePolicy){
	   return new ResponseEntity<InsurancePolicy>(insurancePolicyService.updateInsurancePolicyById(insurancePolicy, id), HttpStatus.OK);
	   }
	 
	   //delete the data
	   //api/clients/id
	   
	   @DeleteMapping("{id}")
	   public ResponseEntity<String>deleteInsurancePolicy(@PathVariable("id")long id){
	   	
	   	insurancePolicyService.deleteInsurancePolicy(id);
	   	return new ResponseEntity<String>("Policy Data deleted successfully!", HttpStatus.OK);
	   }
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
