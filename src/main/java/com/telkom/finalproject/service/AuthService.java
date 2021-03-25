package com.telkom.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telkom.finalproject.model.PeopleModel;
import com.telkom.finalproject.repository.PeopleRepository;
import com.telkom.finalproject.responses.Response;
import com.telkom.finalproject.utils.ResponseCode;
import com.telkom.finalproject.utils.ResponseMessage;

@Service
public class AuthService {
	@Autowired
	private PeopleRepository peopleRepository;
	
	public AuthService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	public Response<PeopleModel> login(String hp, String password) {
		Response<PeopleModel> response = new Response<>();
		
		PeopleModel currentPeople = peopleRepository.getByHp(hp);
		
		boolean loginSuccess = currentPeople != null ? currentPeople.getPassword().equals(password) : false;

		if(loginSuccess) {
			response.setCode(ResponseCode.OK);
			response.setMessage(ResponseMessage.LOGIN_SUCCESS);
			response.setData(currentPeople);
		}else {
			response.setCode(ResponseCode.UNAUTHORIZED);
			response.setMessage(ResponseMessage.LOGIN_FAILED);
		}
		return response;
	}
}
