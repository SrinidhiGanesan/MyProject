package com.example.Insurance.Management.Platform.service;

import java.util.List;

import com.example.Insurance.Management.Platform.model.Claim;

public interface ClaimService  {
	
	Claim saveClaim(Claim claim); 
	 
	List<Claim>getAllClaim();
	 
	Claim getClaimById(long id);
	
	Claim updateClaimById(Claim claim,long id);
	
	 public void deleteClaim(long id);
	
	

}
