package com.telkom.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telkom.finalproject.repository.AdminUserRepository;

@Service
public class AdminUserService {

	private final AdminUserRepository adminUserRepository;
	
	@Autowired
	public AdminUserService(AdminUserRepository adminUserRepository) {
		this.adminUserRepository = adminUserRepository;
	}
	
	
}
