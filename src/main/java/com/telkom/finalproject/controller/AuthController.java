package com.telkom.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telkom.finalproject.model.PeopleModel;
import com.telkom.finalproject.responses.Response;
import com.telkom.finalproject.service.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public Response<PeopleModel> login(@RequestParam("hp") String hp, @RequestParam("password") String password) {
		return authService.login(hp, password);
	}
}
