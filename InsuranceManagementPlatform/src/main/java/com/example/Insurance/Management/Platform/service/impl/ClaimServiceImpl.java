package com.example.Insurance.Management.Platform.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Insurance.Management.Platform.exception.ResourceNotFoundException;
import com.example.Insurance.Management.Platform.model.Claim;
import com.example.Insurance.Management.Platform.repository.ClaimRepository;
import com.example.Insurance.Management.Platform.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	private ClaimRepository claimRepository;

	
	
	
	public ClaimServiceImpl(ClaimRepository claimRepository) {
		super();
		this.claimRepository = claimRepository;
	}

	@Override
	public Claim saveClaim(Claim claim) {
		return claimRepository.save(claim);
		
	}


	@Override
	public List<Claim> getAllClaim() {

         return claimRepository.findAll();
	}



	@Override
	public Claim getClaimById(long id) {
		return claimRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("claim", "Id", id));
	}



	@Override
	public Claim updateClaimById(Claim claim, long id) {
    Claim existingClaim =claimRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("claim", "Id", id));
		
		existingClaim.setId(claim.getId());
		existingClaim.setDescription(claim.getDescription());
//		existingClaim.setPolicy(claim.getPolicy());
	   
		return existingClaim;
	}

	@Override
	public void deleteClaim(long id) {
		claimRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("claim", "Id", id));
		claimRepository.deleteById(id);
		
	}



}
