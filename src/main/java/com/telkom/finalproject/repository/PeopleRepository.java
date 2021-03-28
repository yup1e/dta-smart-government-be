package com.telkom.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telkom.finalproject.model.PeopleModel;

public interface PeopleRepository extends JpaRepository<PeopleModel, Integer>{
	
	PeopleModel getByHp(String hp);
}
