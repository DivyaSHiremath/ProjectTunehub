package com.kodnest.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.UserRepository;
import com.kodnest.tunehub.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository ur;
	public String addUser (User user) {
		ur.save(user);
		return "User added Successfully";
	}
	@Override
	// to check the duplicate entries
	public boolean emailExists(String email) {
		if(ur.findByEmail(email) != null) {
			return true;
		}else {
			return false;
		}

	}
	@Override
	public boolean validateUser(String email, String password) {
	User user =	ur.findByEmail(email);
	String dbpass= user.getPassword();
	if(password.equals(dbpass)) {
		return true;
	} else {
		return false;
	}
	}
	
	@Override
	public String getRole(String email) {
		User user=ur.findByEmail(email);
		return user.getRole();
	}
	@Override
	public User getUser(String email) {
	
		return ur.findByEmail(email);
	}
	@Override
	public void updateUser(User user) {
		ur.save(user);
		
	}
}
	
