package io.egen.test.service;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.egen.dao.UsersDao;
import io.egen.entity.Users;
import io.egen.exception.UserAlreadyExitsException;
import io.egen.exception.UserNotFoundException;
import io.egen.service.UsersService;
import io.egen.service.UsersServiceImpl;
import io.igen.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserServiceTest {

	@Mock
	private UsersDao dao;

	@InjectMocks
	private UsersService service = new UsersServiceImpl();

	private Users user;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		user = new Users();
		user.setPassword("dummy");
		user.setEmail("dummy@dummy.com");
		user.setFirstName("dummy");
		user.setLastName("Users");
		user.setId(UUID.randomUUID().toString());

	}

	@Test
	public void testFindAllUsers() {
		service.findAllUsers();
		Mockito.verify(dao).findAllUsers();
	}

	@Test
	public void testFindUserById() throws UserNotFoundException {
		Mockito.when(dao.findUserById(user.getId())).thenReturn(user);
		Users actual = service.findUserById(user.getId());

		Assert.assertEquals(user, actual);

	}

	@Test(expected = UserNotFoundException.class)
	public void testFindUserByIdException() throws UserNotFoundException {
		Mockito.when(dao.findUserById(user.getId())).thenReturn(null);
		service.findUserById(user.getId());
	}

	@Test
	public void testFindUserByEmailId() throws UserNotFoundException {
		Mockito.when(dao.findUserByEmailId(user.getEmail())).thenReturn(user);
		Users actual = service.findUserByEmailId(user.getEmail());

		Assert.assertEquals(user, actual);

	}

	@Test(expected = UserNotFoundException.class)
	public void testFindUserByEmailIdException() throws UserNotFoundException {
		Mockito.when(dao.findUserByEmailId(user.getEmail())).thenReturn(null);
		service.findUserByEmailId(user.getEmail());

	}

	@Test
	public void testFindUserByEmailAndPassword() throws UserNotFoundException {
		Mockito.when(dao.findUserByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(user);
		Users actual = service.findUserByEmailAndPassword(user.getEmail(), user.getPassword());

		Assert.assertEquals(user, actual);

	}

	@Test(expected = UserNotFoundException.class)
	public void testFindUserByEmailAndPasswordException() throws UserNotFoundException {
		Mockito.when(dao.findUserByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(null);
		service.findUserByEmailAndPassword(user.getEmail(), user.getPassword());

	}

	@Test(expected = UserAlreadyExitsException.class)
	public void testCreateUserException() throws UserAlreadyExitsException {
		Mockito.when(dao.findUserByEmailId(user.getEmail())).thenReturn(user);
		service.createUser(user);

	}

	@Test
	public void testCreateUser() throws UserAlreadyExitsException {
		Mockito.when(dao.findUserByEmailId(user.getEmail())).thenReturn(null);
		service.createUser(user);
		Mockito.verify(dao).createUser(user);

	}

	@Test(expected = UserNotFoundException.class)
	public void testDeleteUserException() throws UserNotFoundException {
		Mockito.when(dao.findUserById(user.getId())).thenReturn(null);
		service.deleteUser(user.getId());
	}

	@Test
	public void testDeleteUser() throws UserNotFoundException {
		Mockito.when(dao.findUserById(user.getId())).thenReturn(user);
		service.deleteUser(user.getId());
		Mockito.verify(dao).deleteUser(user);
	}

	@Test
	public void testUpdateUser() throws UserNotFoundException {
		Mockito.when(dao.findUserById(user.getId())).thenReturn(user);
		service.updateUser(user.getId(), user);
		Mockito.verify(dao).updateUser(user);

	}
	@Test(expected = UserNotFoundException.class)
	public void testUpdateUserException() throws UserNotFoundException {
		Mockito.when(dao.findUserById(user.getId())).thenReturn(null);
		service.updateUser(user.getId(), user);
		

	}

}
