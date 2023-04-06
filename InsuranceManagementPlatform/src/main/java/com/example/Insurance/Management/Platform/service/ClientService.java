package com.example.Insurance.Management.Platform.service;

import java.util.List;

import com.example.Insurance.Management.Platform.model.Client;




public interface ClientService {
	Client saveClient(Client client); 
	 
	 List<Client>getAllClient();
	 
	Client getClientById(int id);
	
	Client updateClientById(Client client,int id);
	
	void deleteClient(int id);

}
