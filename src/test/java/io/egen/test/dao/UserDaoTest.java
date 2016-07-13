package io.egen.test.dao;

import io.egen.dao.UsersDao;
import io.egen.dao.UsersDaoImpl;
import io.egen.entity.Users;
import io.igen.test.TestConfig;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserDaoTest {

	@Mock
	private EntityManager em;

	@InjectMocks
	private UsersDao dao = new UsersDaoImpl();

	@Mock
	private TypedQuery<Users> query;
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
		List<Users> expected = Arrays.asList(user);

		Mockito.when(em.createQuery("SELECT u FROM Users u ORDER BY u.id ASC", Users.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<Users> users = dao.findAllUsers();
		Assert.assertEquals(expected, users);

	}

	@Test
	public void testFindUserById() {
		Mockito.when(em.find(Users.class, user.getId())).thenReturn(user);
		Users actual = dao.findUserById(user.getId());

		Assert.assertEquals(user, actual);
	}
	
	
	@Test
	public void testFindUserByEmailId()
	{
		List<Users> expected = Arrays.asList(user);
		Mockito.when(em.createNamedQuery("Users.findUserByEmailId", Users.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);
		
		Users actual = dao.findUserByEmailId(user.getEmail());
		Assert.assertEquals(user, actual);
	}
    

	@Test
	public void testFindUserByEmailINull()
	{
		
		Mockito.when(em.createNamedQuery("Users.findUserByEmailId", Users.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(null);
		
		Users actual = dao.findUserByEmailId(user.getEmail());
		Assert.assertEquals(null, actual);
	}
	
	
	@Test
	public void testFindUserByEmailIdAndPassword()
	{
		List<Users> expected = Arrays.asList(user);
		Mockito.when(em.createNamedQuery("Users.findUserByEmailAndPassword", Users.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);
		
		Users actual = dao.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		Assert.assertEquals(user, actual);
	}
	
	@Test
	public void testFindUserByEmailIdAndPasswordNull()
	{
		
		Mockito.when(em.createNamedQuery("Users.findUserByEmailAndPassword", Users.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(null);
		
		Users actual = dao.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		Assert.assertEquals(null, actual);
	}
	
	@Test
	public void testCreateUser(){
		dao.createUser(user);
		Mockito.verify(em).persist(user);
	}

	@Test
	public void testUpdateUser(){
		dao.updateUser(user);
		Mockito.verify(em).merge(user);
	}
	@Test
	public void testDeleteUser(){
		dao.deleteUser(user);
		Mockito.verify(em).remove(user);
	}
}
