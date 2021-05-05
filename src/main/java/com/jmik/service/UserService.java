package com.jmik.service;

import com.jmik.storage.User;
import com.jmik.storage.UserRepositry;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

/**
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
}
