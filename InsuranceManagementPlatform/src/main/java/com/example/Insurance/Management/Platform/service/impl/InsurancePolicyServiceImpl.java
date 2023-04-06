package com.example.Insurance.Management.Platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Insurance.Management.Platform.exception.ResourceNotFoundException;
import com.example.Insurance.Management.Platform.model.InsurancePolicy;
import com.example.Insurance.Management.Platform.repository.InsurancePolicyRepository;
import com.example.Insurance.Management.Platform.service.InsurancePolicyService;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService{
@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;
	
	public InsurancePolicyServiceImpl(InsurancePolicyRepository insurancePolicyRepository) {
		super();
		this.insurancePolicyRepository = insurancePolicyRepository;
	}

	@Override
	public InsurancePolicy saveInsurancePolicy(InsurancePolicy insurancePolicy) {
	return insurancePolicyRepository.save(insurancePolicy);
	}

	@Override
	public List<InsurancePolicy> getAllinsurancePolicy() {
		return insurancePolicyRepository.findAll();
	}

	@Override
	public InsurancePolicy getInsurancePolicyById(long id) {
		
		return insurancePolicyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("insurancePolicy", "Id", id));
	}

	@Override
	public InsurancePolicy updateInsurancePolicyById(InsurancePolicy insurancePolicy, long id) {
		
		InsurancePolicy existingInsurancePolicy=insurancePolicyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("insurancePolicy", "Id", id));
		existingInsurancePolicy.setPolicyNumber(insurancePolicy.getPolicyNumber());
		existingInsurancePolicy.setId(insurancePolicy.getId());
		existingInsurancePolicy.setType(insurancePolicy.getType());
		existingInsurancePolicy.setPremium(insurancePolicy.getPremium());
		existingInsurancePolicy.setCoverageAmount(insurancePolicy.getCoverageAmount());
		existingInsurancePolicy.setStartDate(insurancePolicy.getStartDate());
		existingInsurancePolicy.setEndDate(insurancePolicy.getEndDate());
//		existingInsurancePolicy.setClient(insurancePolicy.getClient());
		return existingInsurancePolicy;
	}

	@Override
	public void deleteInsurancePolicy(long id) {
		insurancePolicyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("insurancePolicy", "Id", id));
		insurancePolicyRepository.deleteById(id);
	}

	
	

	
	
}
