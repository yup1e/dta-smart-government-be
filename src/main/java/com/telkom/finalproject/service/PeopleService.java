package com.telkom.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.telkom.finalproject.model.PeopleModel;
import com.telkom.finalproject.repository.PeopleRepository;

@Service
public class PeopleService {
	
	private PeopleRepository peopleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public PeopleService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	public PeopleModel createPeople(PeopleModel peopleModel) {
		peopleModel.setPassword(bCryptPasswordEncoder.encode(peopleModel.getPassword()));
		return peopleRepository.save(peopleModel);
	}
}
