package io.egen.service;

import io.egen.dao.UsersDao;
import io.egen.entity.Users;
import io.egen.exception.UserAlreadyExitsException;
import io.egen.exception.UserNotFoundException;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDao dao;
	
	
	
	@Override
	public Users findUserById(String id) throws UserNotFoundException {
		Users existing = dao.findUserById(id);
		if(existing == null){
			throw new UserNotFoundException();
		}
		else{
			return existing;
		}
	}

	@Override
	public List<Users> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public Users findUserByEmailId(String email) throws UserNotFoundException {
		Users existing = dao.findUserByEmailId(email);
		if(existing == null){
			throw new UserNotFoundException();
		}
		else{
			return existing;
		}
	}

	@Override
	public Users findUserByEmailAndPassword(String email, String password)
			throws UserNotFoundException {
		Users existing = dao.findUserByEmailAndPassword(email,password);
		if(existing == null ){
			throw new UserNotFoundException();
		}else{
			return existing;
		}
	}

	@Override
	public Users updateUser(String id, Users user) throws UserNotFoundException {
		Users existing = dao.findUserById(id);
		if(existing == null){
			throw new UserNotFoundException();
		}
		else{
			return dao.updateUser(user);
		}
	}

	@Override
	public void deleteUser(String id) throws UserNotFoundException {
		Users existing = dao.findUserById(id);
		if(existing == null){
			throw new UserNotFoundException();
		}
		else{
			 dao.deleteUser(existing);
		}

	}
	
	@Override
	public Users createUser(Users users) throws UserAlreadyExitsException {
		Users existing= dao.findUserByEmailId(users.getEmail());
		if(existing == null){
			return dao.createUser(users);
		}
		else
		{
			throw new UserAlreadyExitsException(); 
		}
		 
	}


}
