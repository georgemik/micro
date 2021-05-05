package com.jmik.restapi;

import com.jmik.storage.User;
import com.jmik.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.util.Collections;
import java.util.Optional;

/**
 * @author jmik
 */
@Controller("/api")
public class UserController {
	@Inject
	UserService userService;

	@Get("/user/{id}")
	public HttpResponse<UserDto> getUserById(@PathVariable long id) throws IllegalAccessException {
		//		UserDto usr = new UserDto("abc", "abc", "abc");
		//		usr.setId(5L);
		//		usr.setActive(true);
		//		usr.setTags(Collections.singletonList("abc, def"));
		//
		//		return HttpResponse.ok(usr);

		Optional<User> user = userService.getById(id);
		if (user.isPresent()) {
			return HttpResponse.ok(mapEntityToDto(user.get()));
		}
		return HttpResponse.notFound();
	}

	@Post("/users")
	public UserDto create(UserDto user) {
		User created = userService.save(mapDtoToEntity(user));
		return mapEntityToDto(created);
	}

	private User mapDtoToEntity(UserDto request) {
		User usr = new User();
		usr.setName(request.getName());
		usr.setEmail(request.getEmail());
		usr.setGroup(request.getGroup());
		usr.setActive(request.getActive());
		usr.setTags(request.getTags().toString());
		return usr;
	}

	private UserDto mapEntityToDto(User entity) {
		UserDto user = new UserDto();
		user.setId(entity.getId());
		user.setName(entity.getName());
		user.setEmail(entity.getEmail());
		user.setGroup(entity.getGroup());
		user.setActive(entity.getActive());
		user.setTags(Collections.singletonList(entity.getTags()));
		return user;
	}
}
