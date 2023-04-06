package com.example.Insurance.Management.Platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Insurance.Management.Platform.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
