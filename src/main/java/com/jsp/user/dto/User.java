package com.jsp.user.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	 private Long id;

    private String userName;
    private String phoneNumber;
    private String email;
    @JsonIgnore
    private LocalDateTime createdOn;
    @JsonIgnore
    private LocalDateTime changedOn;

    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserPersonal userPersonal;

//	public Long getId() {
//		return id;
//	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserPersonal getUserPersonal() {
		return userPersonal;
	}

	public void setUserPersonal(UserPersonal userPersonal) {
		this.userPersonal = userPersonal;
	}

	/**
	 * @param id
	 * @param userName
	 * @param phoneNumber
	 * @param email
	 * @param userPersonal
	 */
	public User(Long id, String userName, String phoneNumber, String email, UserPersonal userPersonal) {
		super();
		this.id = id;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.userPersonal = userPersonal;
	}

	/**
	 * 
	 */
	public User() {
		super();
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	@PrePersist
	public void setCreatedOn() {
	 createdOn=LocalDateTime.now();
	 changedOn=LocalDateTime.now();
	}

	public LocalDateTime getChangedOn() {
		return changedOn;
	}
@PreUpdate
	public void setChangedOn() {
		 changedOn = LocalDateTime.now();
	}
    
    
    
}
