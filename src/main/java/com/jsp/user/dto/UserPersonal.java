package com.jsp.user.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class UserPersonal {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    @JsonFormat(pattern = "yyyy-MM-dd")
       private Date dob;
    private String gender;
    private String aadharNo;
    @JsonIgnore
    private LocalDateTime createdOn;
     @JsonIgnore
    private LocalDateTime changedOn;
    
//	public Long getId() {
//		return id;
//	}
    
    
	public void setId(Long id) {
		this.id = id;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	/**
	 * @param id
	 * @param user
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param dob
	 * @param gender
	 * @param aadharNo
	 */
	public UserPersonal(Long id, User user, String firstName, String middleName, String lastName, Date dob,
			String gender, String aadharNo) {
		super();
		this.id = id;
		this.user = user;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.aadharNo = aadharNo;
	}
	/**
	 * 
	 */
	public UserPersonal() {
		super();
	}
	public String getFullName() {
		return fullName;
	}
	
	


//	public Long getId() {
//		return id;
//	}
	
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
		changedOn=LocalDateTime.now();
	}

}
