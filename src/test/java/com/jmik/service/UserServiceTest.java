package com.jmik.service;

import com.jmik.storage.User;
import com.jmik.storage.UserGroup;
import com.jmik.storage.UserRepositry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit test of {@link UserService}
 * @author jmik
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	private static final long ID = 5L;
	@Mock
	UserRepositry userRepositry;
	@InjectMocks
	UserService userService;

	@Test
	public void getById_repositoryCalled() {
		userService.getById(ID);

		verify(userRepositry, times(1)).findById(ID);
	}

	@Test
	public void getAllUsers_repositoryMethodCalled() {
		userService.getAllUsers();

		verify(userRepositry, times(1)).listAll();
	}

	@Test
	public void createUser_repositoryMethodCalled() {
		User createUser = getTestUser(ID);
		userService.createUser(createUser);

		verify(userRepositry, times(1)).save(createUser);
	}

	@Test
	public void updateUser_repositoryMethodCalled() {
		User createUser = getTestUser(ID);
		userService.updateUser(createUser);

		verify(userRepositry, times(1)).update(createUser);
	}

	@Test
	public void deleteUserById_repositoryMethodCalled() {
		userService.deleteById(ID);

		verify(userRepositry, times(1)).deleteById(ID);
	}

	private User getTestUser(long id) {
		User testUser = new User();
		testUser.setId(id);
		testUser.setName("NAME");
		testUser.setEmail("EMAIL@EMAIL");
		testUser.setGroups(List.of(UserGroup.ADMINISTRATORS));
		testUser.setTags(List.of("tag"));
		return testUser;
	}
}