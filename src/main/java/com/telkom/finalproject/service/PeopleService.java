package com.telkom.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telkom.finalproject.model.PeopleModel;
import com.telkom.finalproject.repository.PeopleRepository;

@Service
public class PeopleService {
	
	private PeopleRepository peopleRepository;
	
	@Autowired
	public PeopleService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	public PeopleModel createPeople(PeopleModel peopleModel) {
		return peopleRepository.save(peopleModel);
	}
}
