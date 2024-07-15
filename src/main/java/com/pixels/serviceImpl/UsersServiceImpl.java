package com.pixels.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixels.Repository.userReprository;
import com.pixels.Service.UserService;
import com.pixels.models.Users;

@Service
public class UsersServiceImpl implements UserService{
	
	@Autowired
	private userReprository repo;

	@Override
	public Users login(String username, String password) {
		
		return repo.findByUsernameAndPassword(username, password);
	}

	@Override
	public void adduser(Users users) {
		repo.save(users);
	}

	@Override
	public void deleteuser(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updateuser(Users users) {
		repo.save(users);
		
	}

	@Override
	public Users getUsersbyId(int id) {
	
		return repo.findById(id).get();
	}

	@Override
	public List<Users> getallUsers() {
		
		return repo.findAll();
	}
	

}
