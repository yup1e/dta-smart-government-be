package com.telkom.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telkom.finalproject.model.PeopleModel;
import com.telkom.finalproject.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@PostMapping
	public PeopleModel createPeople(@RequestBody PeopleModel peopleModel) {
		return peopleService.createPeople(peopleModel);
	}
}
