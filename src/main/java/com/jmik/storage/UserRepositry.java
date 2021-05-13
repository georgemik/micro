package com.jmik.storage;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * User repository.
 * @author jmik
 */
@Repository
public interface UserRepositry extends CrudRepository<User, Long> {

	@Executable
	Optional<User> findByName(String name);

	@Executable
	Optional<User> findById(Long id);

	@Executable
	User save(User user);

	@Executable
	void deleteById(Long id);

	@Executable
	List<User> listAll();

	@Executable
	User update(User user);
}
