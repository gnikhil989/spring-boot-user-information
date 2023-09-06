package com.jsp.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.user.dao.UserDao;
import com.jsp.user.dao.UserPersonalDao;
import com.jsp.user.dto.User;

@Service
public class UserService {
@Autowired
UserDao userDao;
@Autowired
UserPersonalDao userPersonalDao;
//====================================to get user by id ===============================================


public User getUserById(Long id) {
	User user=new User();
     user=userDao.findById(id).get();
     if(user!=null) {
    	 user.setUserPersonal(userPersonalDao.findById(id).get());
     }
     return user;
}

//=====================================to get all user =================================================

public List<User> getAllUsers() {
    return userDao.findAll();
}

//=====================================to update user by id =============================================
public boolean updateUser(Long id,User user) {
	System.out.println(id);
	User user2= new User();
user2=userDao.findById(id).get();
	System.out.println(user2.getUserName());
	System.out.println(user.getUserName());
	if(user2!=null) {
		user2.setEmail(user.getEmail());
		user2.setPhoneNumber(user.getPhoneNumber());
		user2.setUserName(user.getUserName());
		user2.setChangedOn();
		user2.getUserPersonal().setFullName(user2.getUserPersonal().getLastName()+" "+user2.getUserPersonal().getFirstName()+" "+user2.getUserPersonal().getMiddleName());
		user2.setUserPersonal(user2.getUserPersonal());
	
		 userDao.save(user2);
		 return true;
	}else {
		return false;
	}
   
}

//==========================================delete user by id ==================================================

public boolean deleteUser(Long id) {
	User user=userDao.findById(id).get();
	if(user!=null) {
		  userDao.deleteById(id);
		  return true;
	}else{
		return false;
	}
  
}
//======================================== to save user =========================================================

public ResponseEntity<String> saveUser(User user) {
	user.getUserPersonal().setFullName(user.getUserPersonal().getLastName()+" "+user.getUserPersonal().getFirstName()+" "+user.getUserPersonal().getMiddleName());
	  user.setUserPersonal(user.getUserPersonal());
	userDao.save(user);
	return new ResponseEntity<String>("user created ", HttpStatus.CREATED);
}
}
