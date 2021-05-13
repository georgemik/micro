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

	/**
	 * Get user by id.
	 * @param id
	 * @return
	 */
	public Optional<User> getById(Long id) {
		return userRepositry.findById(id);
	}

	/**
	 * Get all users.
	 * @return
	 */
	public List<User> getAllUsers() {
		return userRepositry.listAll();
	}

	/**
	 * Create the user.
	 * @param user
	 * @return
	 */
	public User createUser(User user) {
		return userRepositry.save(user);
	}

	/**
	 * Update the user.
	 * @param user
	 * @return
	 */
	public User updateUser(User user) {
		return userRepositry.update(user);
	}

	/**
	 * Delete user with id.
	 * @param id
	 */
	public void deleteById(Long id) {
		userRepositry.deleteById(id);
	}
}
