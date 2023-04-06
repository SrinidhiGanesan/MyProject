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
import com.example.Insurance.Management.Platform.model.Claim;
import com.example.Insurance.Management.Platform.service.ClaimService;


@RestController
@RequestMapping("/api/claims")
public class ClaimController {
	 
	@Autowired
	  private ClaimService claimService;
	  
   //Add values
	///api/claims
	 
	@PostMapping
	   public ResponseEntity<Claim>saveClaim(@RequestBody Claim claim){
		   return new ResponseEntity<Claim>(claimService.saveClaim(claim),HttpStatus.CREATED);
	   }
	
	//Retrive All the values  
	@GetMapping
	   public List<Claim>getAllClaims(){
		   return claimService.getAllClaim();
	}
	
	//Retrive data by id
	//api/claims/id
	 @GetMapping("{id}")
		public ResponseEntity<Claim>getClaimById(@PathVariable("id")long claim){
			return new ResponseEntity<Claim>(claimService.getClaimById(claim),HttpStatus.OK);
	 }
	 
	 //Update data by id
	 //api/claims/id
	  @PutMapping("{id}")
	   public ResponseEntity<Claim>updateClaimById(@PathVariable("id")long id,@RequestBody Claim claim){
	   return new ResponseEntity<Claim>(claimService.updateClaimById(claim, id), HttpStatus.OK);
	   	
	   }
	  
	  //delete data by id
	  //api/claims/id
	
	  @DeleteMapping("{id}")
	  public ResponseEntity<String>deleteClaimById(@PathVariable("id")long id)
	  {
		  claimService.deleteClaim(id);
		  return new ResponseEntity<String>("Claims Data Deleted Successfully!",HttpStatus.OK);
	  }
		   

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
