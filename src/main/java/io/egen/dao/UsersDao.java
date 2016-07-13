package io.egen.dao;

import java.util.List;

import io.egen.entity.Users;

public interface UsersDao {

	public Users findUserById(String id);

	public Users findUserByEmailId(String email);

	public Users createUser(Users users);

	public List<Users> findAllUsers();

	public Users findUserByEmailAndPassword(String email, String password);
	
	public Users updateUser(Users user);

	public void deleteUser(Users user);



}
