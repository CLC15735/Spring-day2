package com.qa.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.service.GuitaristService;


@RestController
@RequestMapping("/guitarist")
public class GuitaristController {
	
	//Re - Representational
	//S - State
	//T - Transfer
	
	public GuitaristService service;
	
	@Autowired 
	//wired up to the object in object creation
	//If the wiring fails, the object never gets created
	public GuitaristController(GuitaristService service) {
		super();
		this.service = service;
	}
	
	

	
	//Create
	//Read
	//ReadById
	//Update
	//Delete
	

}
