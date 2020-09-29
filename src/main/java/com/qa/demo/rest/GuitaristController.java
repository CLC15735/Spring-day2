package com.qa.demo.rest;

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

import com.qa.demo.dto.GuitaristDTO;
import com.qa.demo.service.GuitaristService;


@RestController
@RequestMapping("/guitarist")
public class GuitaristController {
	
	//Re - Representational
	//S - State
	//T - Transfer
	
	//@Autowired
	//Spring reflects in a setter we cannot see
	//this is run AFTER our controller gets created
	//if the setter method fails, we end up with a controller that is not wired up to the Service
	//which will cause exceptions later down the line
	public GuitaristService service;
	
	@Autowired 
	//wired up to the object in object creation
	//If the wiring fails, the object never gets created
	//This causes fewer exceptions, if we want to make sure our autowiring has worked,
	//all we need to do if the Controller exists
	public GuitaristController(GuitaristService service) {
		super();
		this.service = service;
	}
	
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<GuitaristDTO> create(@RequestBody GuitaristDTO guitaristDTO){
		//Creates the entity and passes it back (through the service to repository to domain to database)
		GuitaristDTO created = this.service.createGuitarist(guitaristDTO);
		//returns the entity in a RespnseEntity format, which converts it into JSON so we can read it
		return new ResponseEntity<>(created, HttpStatus.CREATED);
		
	}
	
	//Read
	@GetMapping("/read")
	public ResponseEntity<List<GuitaristDTO>> getAllGuitarist() {
		return ResponseEntity.ok(this.service.readAllGuitarist());
	}
	
	//ReadById
	@GetMapping("/read/{id}")
	public ResponseEntity<GuitaristDTO> getGuitaristById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.readById(id));
	}
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<GuitaristDTO> updateGuitarisById(@PathVariable Long id, @RequestBody GuitaristDTO guitaristDTO){
		GuitaristDTO updated = this.service.update(guitaristDTO, id);
		return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GuitaristDTO> deleteGuitaristById(@PathVariable Long id) {
		
		return this.service.delete(id)
				?new ResponseEntity<>(HttpStatus.NO_CONTENT) //If you get an error code 204
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //print instead a 500 which is scarier
		
	}
	

}
