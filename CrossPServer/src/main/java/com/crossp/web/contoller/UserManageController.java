package com.crossp.web.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossp.jpa.domain.User;
import com.crossp.jpa.service.UserRepository;

@RestController
@RequestMapping("/admin")
public class UserManageController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value="/user")
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/user/{id}")
	public User getUser(@PathVariable("id") long id) {
		return userRepository.findOne(id);
	}
	
	
	@RequestMapping(value="/user/add")
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	@RequestMapping(value="/user/delete")
	public void deleteUser(User user) {
		userRepository.delete(user);;
	}
	
	@RequestMapping(value="/user/delete/{id}")
	public void deleteUserId(@PathVariable("id") long id) {
		userRepository.delete(id);;
	}	
}
