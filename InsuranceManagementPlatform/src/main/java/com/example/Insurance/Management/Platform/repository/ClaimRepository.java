package com.example.Insurance.Management.Platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Insurance.Management.Platform.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
