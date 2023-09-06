package com.jsp.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.user.dto.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	

}
