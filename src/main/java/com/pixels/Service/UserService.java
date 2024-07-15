package com.pixels.Service;

import java.util.List;

import com.pixels.models.Users;

public interface UserService {
	
	Users login(String username, String password);
	void adduser(Users users);
	void deleteuser(int id);
	void updateuser(Users users);
	Users getUsersbyId(int id);
	List<Users> getallUsers();

}
