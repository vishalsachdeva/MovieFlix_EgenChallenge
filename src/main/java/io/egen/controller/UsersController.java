package io.egen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.egen.entity.Users;
import io.egen.exception.UserAlreadyExitsException;
import io.egen.exception.UserNotFoundException;
import io.egen.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
@Api(tags="users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/signup",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a new User", notes = "Create the new User in the system if it is not present in system")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Users createUser(@RequestBody Users user) throws UserAlreadyExitsException   {
		return usersService.createUser(user);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find All Users", notes = "Returns the list of Users in the system.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Users> findAllUser() {
		return usersService.findAllUsers();
	}
	
	@RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find User from Specified ID", notes = "Returns the User from the system with same ID.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "User is not found in the system"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Users findUserById(@PathVariable("id") String id)
			throws  UserNotFoundException {
		return usersService.findUserById(id);
	}
	@RequestMapping(value = "email/{email:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find User from Specified email", notes = "Returns the User from the system with same email")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "User is not found in the system"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Users findUserByEmailId(@PathVariable("email") String email)
			throws  UserNotFoundException {
		return usersService.findUserByEmailId(email);
	}
	
	@RequestMapping(value = "email/{email:.+}/{password}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find User from Specified email and password", notes = "Returns the User from the system with same email and password")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "User is not found in the system"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Users findUserByEmailIdAndPassword(@PathVariable("email") String email, @PathVariable("password") String password)
			throws  UserNotFoundException {
		return usersService.findUserByEmailAndPassword(email,password);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find User from Specified ID", notes = "Returns the User from the system with same ID.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "User is not found in the system"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Users findUserByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request)
			throws  UserNotFoundException {	
			System.out.println(email);
		 return usersService.findUserByEmailAndPassword(email,password);		 
		 
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update User", notes = "Update an existing User")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Users updateUser(@PathVariable("id") String id, @RequestBody Users user)
			throws UserNotFoundException {
		return usersService.updateUser(id, user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete User", notes = "Delete an existing User")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public void deleteUser(@PathVariable("id") String id)
			throws UserNotFoundException {
		usersService.deleteUser(id);
	}
	
	
	
	
	
}
