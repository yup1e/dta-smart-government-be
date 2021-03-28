package com.telkom.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telkom.finalproject.model.AdminUserModel;
import com.telkom.finalproject.model.PeopleModel;
import com.telkom.finalproject.responses.Response;
import com.telkom.finalproject.service.AuthService;

@RestController
@RequestMapping(path = "api/v1")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/auth/login")
	public Response<PeopleModel> login(@RequestParam("hp") String hp, @RequestParam("password") String password) {
		return authService.login(hp, password);
	}
	
	@PostMapping("/admin/login")
	public Response<AdminUserModel> loginAdmin(@RequestParam("username") String username, @RequestParam("password") String password) {
		return authService.loginAdmin(username, password);
	}
}
