package com.telkom.finalproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "people")
public class PeopleModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "people_id")
	private int peopleId;
	
	@Column(name = "email")
	private String email; 

	@Column(name = "hp")
	private String hp; 
	
	@Column(name = "password")
	private String password; 
	
	@Column(name = "kk")
	private String kk; 
	
	@Column(name = "is_active", nullable = false, columnDefinition = "BIT(1)")
	private boolean isActive; 
	
	@Column(name = "is_agree", nullable = false, columnDefinition = "BIT(1)")
	private boolean isAgree; 
	
	@Column(name = "date_register")
	private Date dateRegister; 
	
	
	public int getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKk() {
		return kk;
	}

	public void setKk(String kk) {
		this.kk = kk;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(boolean isAgree) {
		this.isAgree = isAgree;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}
}
