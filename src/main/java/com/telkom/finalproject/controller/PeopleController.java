package com.telkom.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telkom.finalproject.model.PeopleModel;
import com.telkom.finalproject.service.PeopleService;

@RestController
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@PostMapping("/api/v1/register")
	public PeopleModel createPeople(@RequestBody PeopleModel peopleModel) {
		return peopleService.createPeople(peopleModel);
	}
	
	@GetMapping("/helloworld")
	public String helloworld() {
		return "Hello World";
	}
	
}
