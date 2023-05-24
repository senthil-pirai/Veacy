package com.pirai.user.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.pirai.user.entity.User;
import com.pirai.user.entity.requestModel.UserModel;

public interface UserService {

	List<User> getAllUsers();
	Optional<User> getUserByUserName(String userName);
	String createUser(UserModel userModel);
	String updateUser(Map<String,Object> userModel,String userName);
	String deleteUserByUserName(String userName);
}
