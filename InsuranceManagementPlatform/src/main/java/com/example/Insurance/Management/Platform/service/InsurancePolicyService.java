package com.example.Insurance.Management.Platform.service;

import java.util.List;

import com.example.Insurance.Management.Platform.model.InsurancePolicy;

public interface InsurancePolicyService {
	 
	InsurancePolicy saveInsurancePolicy(InsurancePolicy insurancePolicy); 
	 
	 List<InsurancePolicy>getAllinsurancePolicy();
	 
	 InsurancePolicy getInsurancePolicyById(long id);
	
	 InsurancePolicy updateInsurancePolicyById(InsurancePolicy insurancePolicy,long id);
	
	void deleteInsurancePolicy(long id);


}
