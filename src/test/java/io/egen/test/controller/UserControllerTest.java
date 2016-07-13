package io.egen.test.controller;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.egen.controller.UsersController;
import io.egen.entity.Users;
import io.egen.service.UsersService;
import io.igen.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserControllerTest {

	@Mock
	private UsersService usersService;

	@InjectMocks
	private UsersController controller;
	
	private MockMvc mockMvc;
	
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

		mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
	}

	
	@Test
	public void testFindAllUser() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/users"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	
		Mockito.verify(usersService).findAllUsers();
	}
	
	@Test
	public void testFindUserById() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/users/id/"+ user.getId()))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(usersService).findUserById(user.getId());
	
	
	}
	
	
}
