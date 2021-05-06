package com.jmik.service;

import com.jmik.storage.User;
import com.jmik.storage.UserRepositry;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

/**
 * Services for user CRUD operations.
 * @author jmik
 */
@Singleton
public class UserService {
	@Inject
	UserRepositry userRepositry;

	public User save(User user) {
		return userRepositry.save(user);
	}

	public Optional<User> getById(Long id) {
		return userRepositry.findById(id);
	}

	public void deleteById(Long id) {
		userRepositry.deleteById(id);
	}

	public List<User> getAllUsers() {
		return userRepositry.listAll();
	}

	public User modifyUser(User user) {
		return userRepositry.update(user);
	}
}
