package com.example.Insurance.Management.Platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Insurance.Management.Platform.model.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long>{

}
