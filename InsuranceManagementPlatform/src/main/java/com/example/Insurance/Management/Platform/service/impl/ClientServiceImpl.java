package com.example.Insurance.Management.Platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Insurance.Management.Platform.exception.ResourceNotFoundException;
import com.example.Insurance.Management.Platform.model.Client;
import com.example.Insurance.Management.Platform.repository.ClientRepository;
import com.example.Insurance.Management.Platform.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	
	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
		
	}
	
	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}
	
	

	@Override
	public Client getClientById(int id) {
		return clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("client", "Id", id));
	}

	@Override
	public Client updateClientById(Client client, int id) {
		Client existingClient=clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("client", "Id", id));
		existingClient.setId(client.getId());
		existingClient.setName(client.getName());
		existingClient.setDateOfBirth(client.getDateOfBirth());
		existingClient.setAddress(client.getAddress());
		existingClient.setContactInformation(client.getContactInformation());
		return existingClient;
		
	}

	@Override
	public void deleteClient(int id) {
		
		clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("client", "Id", id));
		clientRepository.deleteById(id);
		
	}

	 

	

}
