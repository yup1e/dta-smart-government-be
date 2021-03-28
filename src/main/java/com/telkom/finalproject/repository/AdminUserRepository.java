package com.telkom.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telkom.finalproject.model.AdminUserModel;

public interface AdminUserRepository extends JpaRepository<AdminUserModel, Integer> {

	AdminUserModel getByUsername(String username);
}
