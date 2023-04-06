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

import com.example.Insurance.Management.Platform.model.Client;
import com.example.Insurance.Management.Platform.service.ClientService;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
	@Autowired
	 private ClientService clientService;
	  
	 public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@PostMapping
	   public ResponseEntity<Client>saveClient(@RequestBody Client client ){
		return new ResponseEntity<Client>(clientService.saveClient(client),HttpStatus.CREATED);
	}

	  //getAllClientById
	   
	 @GetMapping
	   public List<Client>getAllClients(){
		   return clientService.getAllClient();
	   }
	 
	// getClientById
	 @GetMapping("{id}")
		public ResponseEntity<Client>getClientById(@PathVariable("id")int client){
			return new ResponseEntity<Client>(clientService.getClientById(client),HttpStatus.OK);
		 
	 
	 }
			
	   
	  //update client
	   @PutMapping("{id}")
	   public ResponseEntity<Client>updateClientById(@PathVariable("id")int id,@RequestBody Client client){
	   return new ResponseEntity<Client>(clientService.updateClientById(client, id), HttpStatus.OK);
	   	
	   }
	   
	   @DeleteMapping("{id}")
	   public ResponseEntity<String>deleteClient(@PathVariable("id")int id){
	   	
	   	clientService.deleteClient(id);
	   	return new ResponseEntity<String>("Data deleted successfully!", HttpStatus.OK);
	   	
	   }



	 
	

}
