package com.jmik.restapi;

import com.jmik.restapi.utils.ApiUtils;
import com.jmik.service.UserService;
import com.jmik.storage.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jmik.restapi.utils.ThrowErrorFixture.notFound;

/**
 * REST API controller for user CRUD operations.
 * @author jmik
 */
@Controller("/api")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Inject
	UserService userService;
	@Inject
	ApiUtils apiUtils;

	@Get("/users")
	public HttpResponse<UserListDto> getUsers() {
		List<User> users = userService.getAllUsers();
		List<UserDto> usersDto = users.stream().map(this::mapEntityToDto).collect(Collectors.toList());
		UserListDto dto = new UserListDto();
		dto.setData(usersDto);
		dto.setCount(usersDto.size());
		return HttpResponse.ok(dto);
	}

	@Get("/users/{id}")
	public UserDto getUserById(@PathVariable long id) {
		Optional<User> user = userService.getById(id);
		if (user.isEmpty()) {
			throw notFound(String.format("User %d not found", id));
		}
		return mapEntityToDto(user.get());
	}

	@Post("/users")
	public HttpResponse<UserDto> create(@Valid UserDto user) {
		User created = userService.save(mapDtoToEntity(user));
		return HttpResponse.created(mapEntityToDto(created));
	}

	@Delete("/users/{id}")
	public HttpStatus delete(@PathVariable long id) {
		Optional<User> existingUser = userService.getById(id);
		if (existingUser.isEmpty()) {
			throw notFound(String.format("User %d not found", id));
		}
		userService.deleteById(id);
		return HttpStatus.OK;
	}

	@Put("/users/{id}")
	public HttpResponse<UserDto> updateUser(@Valid UserDto user, @PathVariable long id) {
		Optional<User> existingUser = userService.getById(id);
		if (existingUser.isEmpty()) {
			throw notFound(String.format("User %d not found", id));
		}
		User response = userService.updateUser(mapDtoToEntity(user));
		return HttpResponse.ok(mapEntityToDto(response));
	}

	private User mapDtoToEntity(UserDto request) {
		User usr = new User();
		if (request.getId() != null) {
			usr.setId(request.getId());
		}
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
//		needs improvement
		user.setTags(Collections.singletonList(entity.getTags()));
		user.setHref(apiUtils.getHref());
		return user;
	}

	static class UserListDto extends ListDto<UserDto> {
	}
}
