package com.athulbabu.azstudio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athulbabu.azstudio.model.user;

public interface user_Dao extends JpaRepository<user, Integer> {

	user findByEmail(String user_email);

}
