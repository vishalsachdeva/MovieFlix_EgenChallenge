package io.egen.service;

import java.util.List;

import io.egen.entity.Users;
import io.egen.exception.UserAlreadyExitsException;
import io.egen.exception.UserNotFoundException;

public interface UsersService {

	Users createUser(Users users) throws UserAlreadyExitsException;

	Users findUserById(String id) throws UserNotFoundException;

	List<Users> findAllUsers();

	Users findUserByEmailId(String email) throws UserNotFoundException;

	Users findUserByEmailAndPassword(String email, String password)
			throws UserNotFoundException;

	Users updateUser(String id, Users user) throws UserNotFoundException;

	void deleteUser(String id) throws UserNotFoundException;

}
