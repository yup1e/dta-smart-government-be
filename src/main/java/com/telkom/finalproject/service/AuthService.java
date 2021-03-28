package com.telkom.finalproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telkom.finalproject.model.AdminUserModel;
import com.telkom.finalproject.model.PeopleModel;
import com.telkom.finalproject.repository.AdminUserRepository;
import com.telkom.finalproject.repository.PeopleRepository;
import com.telkom.finalproject.responses.Response;
import com.telkom.finalproject.utils.ResponseCode;
import com.telkom.finalproject.utils.ResponseMessage;

@Service
public class AuthService implements UserDetailsService{
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private AdminUserRepository adminUserRepository;
	
	public AuthService(PeopleRepository peopleRepository, AdminUserRepository adminUserRepository) {
		this.peopleRepository = peopleRepository;
		this.adminUserRepository = adminUserRepository;
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
	
	public Response<AdminUserModel> loginAdmin(String username, String password) {
		Response<AdminUserModel> response = new Response<>();
		
		AdminUserModel currentUser = adminUserRepository.getByUsername(username);
		
		boolean loginSuccess = currentUser != null ? currentUser.getPassword().equals(password) : false;

		if(loginSuccess) {
			response.setCode(ResponseCode.OK);
			response.setMessage(ResponseMessage.LOGIN_SUCCESS);
			response.setData(currentUser);
		}else {
			response.setCode(ResponseCode.UNAUTHORIZED);
			response.setMessage(ResponseMessage.LOGIN_FAILED);
		}
		return response;
	}

	@Override
	public UserDetails loadUserByUsername(String hp) throws UsernameNotFoundException {
		System.out.println("masukkkk");
		PeopleModel peopleModel = peopleRepository.getByHp(hp);
		if(peopleModel != null) {
			return new User(peopleModel.getHp(), peopleModel.getPassword(), new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found");
		}
	}
}
