package com.pirai.user.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.pirai.user.entity.User;
import com.pirai.user.entity.requestModel.UserModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User Controller")
public interface UserControllerConfig {

	@ApiResponses({
		@ApiResponse(responseCode = "200", content = {
				@Content(schema = @Schema(), mediaType = "application/json") }),
	})
	@Operation(summary = "this method shows all the users")
	public List<User> getAllUsers();
	
	@ApiResponses({
		@ApiResponse(responseCode = "200", content = {
				@Content(schema = @Schema(), mediaType = "application/json") }),
	})
	@Operation(summary = "this method finds a user by their username")
	public Optional<User> getUsersByUserName(String userName);
	
	@ApiResponses({
		@ApiResponse(responseCode = "200", content = {
				@Content(schema = @Schema(), mediaType = "application/json") }),
	})
	@Operation(summary = "this method creates a user")
	public String createUser(UserModel userModel);
	
	@ApiResponses({
		@ApiResponse(responseCode = "200", content = {
				@Content(schema = @Schema(), mediaType = "application/json") }),
	})
	@Operation(summary = "this method updates a user")
	public String updateUser(Map<String,Object> userModel,String userName);
	
	@ApiResponses({
		@ApiResponse(responseCode = "200", content = {
				@Content(schema = @Schema(), mediaType = "application/json") }),
	})
	@Operation(summary = "this method deletes a user by their username")
	public String deleteUserByUserName(String userName);
}
