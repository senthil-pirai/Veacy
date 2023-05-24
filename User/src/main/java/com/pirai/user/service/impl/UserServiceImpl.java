package com.pirai.user.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pirai.user.entity.Audit;
import com.pirai.user.entity.Role;
import com.pirai.user.entity.User;
import com.pirai.user.entity.requestModel.UserModel;
import com.pirai.user.repository.UserRepository;
import com.pirai.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public List<User> getAllUsers() {
		log.info("The method getAllUsers has been called");
		Optional<List<User>> temp = Optional.of(userRepository.findAll());
		if(temp.isEmpty()) {
			log.warn("No Users available");
		}
		else {
			log.debug("The displayed details:\n"+userRepository.findAll());
		}
		log.info("The method getAllUsers has been ended");
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserByUserName(String userName) {
		log.info("The method getUserByUserName has been called");
		Optional<User> temp = userRepository.findByUserName(userName);
		if(temp.isEmpty()) {
			log.warn("User with username "+userName+" doesn't exists");
		}
		else {
			log.debug("The displayed details:\n"+userRepository.findByUserName(userName));
		}
		log.info("The method getUserByUserName has been ended");
		return userRepository.findByUserName(userName);
	}

	@Override
	public String createUser(UserModel userModel) {
		log.info("The method createUser has been called");
		try {
			User user = new User();
			Role roleId = new Role();
			roleId.setId(userModel.getRoleId());
			Audit auditId = new Audit();
			auditId.setId(userModel.getAuditingId());
			user.setName(userModel.getName());
            user.setEmail(userModel.getEmail());
            user.setMobileNo(userModel.getMobileNo());
            user.setUserName(userModel.getUserName());   
            user.setRoleId(roleId);
            user.setAuditingId(auditId);
            user.setIsActive(userModel.getIsActive());
            user.setIsDeleted(userModel.getIsDeleted());
			userRepository.save(user);
			log.debug("The created user details:\n"+userRepository.save(user));
		}
		catch (Exception e) {
			log.error("error <------> "+e.getMessage());
			log.info("The method createUser has been ended");
			return "error <------> "+e.getMessage();
		}
		log.info("The method createUser has been ended");
		return "User created successfully!";	
	}

	@Override
	public String updateUser(Map<String,Object> userModel,String userName) {
		log.info("The method updateUser has been called");
		Optional<User> existingUser = userRepository.findByUserName(userName);
		if(existingUser.isPresent())
        {
			User updatedUser = existingUser.get();
			
			
			userModel.forEach((field,value) -> {
				switch (field) {
                case "name":
                    updatedUser.setName((String) value);
                    break;
                case "email":
                    updatedUser.setEmail((String) value);
                    break;
                case "mobileNo":
                    updatedUser.setMobileNo((String) value);
                    break;
                case "userName":
                    updatedUser.setUserName((String) value);
                    break;
                case "roleId":
                	Role roleId = new Role();
        			roleId.setId(Long.valueOf((int) value));
                	updatedUser.setRoleId(roleId);
                	break;
                case "auditingId":
                	Audit auditId = new Audit();
        			auditId.setId(Long.valueOf((int) value));
                	updatedUser.setAuditingId(auditId);
                	break;
                case "isActive":
                    updatedUser.setIsActive((Boolean) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + field);
			   }
			});
			userRepository.save(updatedUser);
			log.debug("The updated user details:\n"+updatedUser);
			return "User updated successfully!!";
        }
        else
        {
			log.warn("User with username "+userName+" doesn't exists");
			log.info("The method updateUser has been ended");
            return "User not found!";
        }
	}

	@Override
	public String deleteUserByUserName(String userName) {
		log.info("The method deleteUserByUserName has been called");
		try {
			Optional<User> temp = userRepository.findByUserName(userName);
			if(temp.isEmpty()) {
				log.warn("User with username "+userName+" doesn't exists");
				log.info("The method deleteUserByUserName has been ended");
				return "User with username "+userName+" doesn't exists!";
			}
			User user = temp.get();
			log.debug("The user with username "+userName+" has been deleted");
			userRepository.deleteById(user.getId());
			
		}
		catch (Exception e) {
			log.error("error <------> "+e.getMessage());
			log.info("The method deleteUserByUserName has been ended");
			return "error <------> "+e.getMessage();
		}
		log.info("The method deleteUserByUserName has been ended");
		return "User: "+userName +" deleted successfully!";

	}

}
