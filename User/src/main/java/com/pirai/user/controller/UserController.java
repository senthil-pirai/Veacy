package com.pirai.user.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pirai.user.entity.User;
import com.pirai.user.entity.requestModel.UserModel;
import com.pirai.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerConfig{

	@Autowired
	UserService impl;
	
	@GetMapping
	public List<User> getAllUsers(){
		return impl.getAllUsers();
	}
	
	@GetMapping("/{userName}")
	public Optional<User> getUsersByUserName(@PathVariable String userName){
		return impl.getUserByUserName(userName);
	}
	
	@PostMapping
	public String createUser(@RequestBody UserModel userModel) {
		return impl.createUser(userModel);
	}
	
	@PutMapping("/{userName}")
	public String updateUser(@RequestBody Map<String,Object> userModel,@PathVariable String userName) {
		return impl.updateUser(userModel,userName);
	}
	
	@DeleteMapping("/{userName}")
	public String deleteUserByUserName(@PathVariable String userName) {
		return impl.deleteUserByUserName(userName);
	}
	
}
