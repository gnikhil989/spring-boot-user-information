package com.jsp.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.user.dto.UserPersonal;

@Repository
public interface UserPersonalDao extends JpaRepository<UserPersonal, Long> {

}
