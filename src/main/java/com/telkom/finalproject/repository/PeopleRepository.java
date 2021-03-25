package com.telkom.finalproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.telkom.finalproject.model.PeopleModel;

public interface PeopleRepository extends CrudRepository<PeopleModel, Integer>{
	
	PeopleModel getByHp(String hp);
}
