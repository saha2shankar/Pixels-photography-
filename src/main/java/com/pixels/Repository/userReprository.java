package com.pixels.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pixels.models.Users;

public interface userReprository extends JpaRepository<Users, Integer>{
	Users findByUsernameAndPassword(String username, String password);
}
