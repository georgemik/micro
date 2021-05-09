package com.jmik.restapi;

import com.jmik.restapi.utils.ApiUtils;
import com.jmik.service.UserService;
import com.jmik.storage.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Unit test for {@link UserController}.
 * @author jmik
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
	private static final long ID = 5L;
	private static final String NAME = "test";
	private static final String EMAIL = "test@test";
	private static final String GROUP = "group";
	private static final String HREF = "http://test.href/api/users/x";
	private static final String EXPECTED_MSG = "User 5 not found";
	private static final List<String> TAGS = Arrays.asList("tag1", "tag2", "tag3");
	@Mock
	UserService userService;
	@Mock
	ApiUtils apiUtils;
	@InjectMocks
	private UserController userController;

	@Test
	public void getUserById_userDoesNotExist_exThrown() {
		ApiException expectedEx = assertThrows(ApiException.class, () -> userController.getUserById(ID));

		assertEquals(expectedEx.getMessage(), EXPECTED_MSG);
		assertEquals(expectedEx.getStatus(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void delete_userDoesNotExists_exThrown() {
		ApiException expectedEx = assertThrows(ApiException.class, () -> userController.delete(ID));

		assertEquals(expectedEx.getMessage(), EXPECTED_MSG);
		assertEquals(expectedEx.getStatus(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void updateUser_userDoesNotExists_exThrown() {
		ApiException expectedEx = assertThrows(ApiException.class, () -> userController.updateUser(getTestUserDto(ID), ID));

		assertEquals(expectedEx.getMessage(), EXPECTED_MSG);
		assertEquals(expectedEx.getStatus(), HttpStatus.NOT_FOUND);
	}

	@Test
	void updateUser_idNotDefined_exThrown() {
		ApiException expectedEx = assertThrows(ApiException.class, () -> userController.updateUser(new UserDto(), ID));

		assertEquals(expectedEx.getMessage(), "Id must not be null");
		assertEquals(expectedEx.getStatus(), HttpStatus.BAD_REQUEST);
	}

	@Test
	public void deleteUser_userExists_userDeleted() {
		when(userService.getById(ID)).thenReturn(getTestUser(ID));

		HttpStatus status = userController.delete(ID);
		assertEquals(status, HttpStatus.OK);
	}

	@Test
	public void updateUser_userExists_userUpdated() {
		when(apiUtils.getHref(anyString())).thenReturn(HREF);
		User testUser = getTestUserObj(ID);
		UserDto testUserDto = getTestUserDto(ID);
		when(userService.getById(ID)).thenReturn(getTestUser(ID));
		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
		when(userService.updateUser(userArgumentCaptor.capture())).thenReturn(testUser);

		HttpResponse<UserDto> response = userController.updateUser(testUserDto, ID);

		assertThat(userArgumentCaptor.getValue()).usingRecursiveComparison().isEqualTo(testUser);
		assertThat(response.body()).usingRecursiveComparison().isEqualTo(testUserDto);
		assertEquals(response.status(), HttpStatus.OK);
	}

	@Test
	public void getUsers_correctUsersReturned() {
		when(apiUtils.getHref(anyString())).thenReturn(HREF);
		UserDto expectedUser = getTestUserDto(ID);
		when(userService.getAllUsers()).thenReturn(List.of(getTestUserObj(ID)));

		HttpResponse<UserController.UserListDto> response = userController.getUsers();

		assertEquals(response.body().getCount(), 1);
		assertThat(response.body().getData().get(0)).usingRecursiveComparison().isEqualTo(expectedUser);
		assertEquals(response.status(), HttpStatus.OK);
	}

	@Test
	public void getUserById_userExists_correctDtoMapped() {
		when(apiUtils.getHref(anyString())).thenReturn(HREF);
		UserDto expectedUser = getTestUserDto(ID);
		when(userService.getById(ID)).thenReturn(getTestUser(ID));

		UserDto user = userController.getUserById(ID);
		assertThat(user).usingRecursiveComparison().isEqualTo(expectedUser);
	}

	@Test
	public void create_userCreated() {
		when(apiUtils.getHref(anyString())).thenReturn(HREF);
		UserDto expectedUserDto = getTestUserDto(ID);
		User expectedUser = getTestUserObj(ID);
		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
		when(userService.save(userArgumentCaptor.capture())).thenReturn(expectedUser);

		HttpResponse<UserDto> response = userController.create(expectedUserDto);

		assertThat(userArgumentCaptor.getValue()).usingRecursiveComparison().isEqualTo(expectedUser);
		assertThat(response.body()).usingRecursiveComparison().isEqualTo(expectedUserDto);
		assertEquals(response.status(), HttpStatus.CREATED);
	}

	@Test
	public void delete_userDeleted() {
		doNothing().when(userService).deleteById(anyLong());
		when(userService.getById(ID)).thenReturn(getTestUser(ID));

		HttpStatus status = userController.delete(ID);

		verify(userService, times(1)).deleteById(ID);
		assertEquals(status, HttpStatus.OK);
	}

	private Optional<User> getTestUser(long id) {
		User testUser = new User();
		testUser.setId(id);
		testUser.setName(NAME);
		testUser.setEmail(EMAIL);
		testUser.setGroup(GROUP);
		testUser.setTags(TAGS);
		return Optional.of(testUser);
	}

	private User getTestUserObj(long id) {
		return getTestUser(id).get();
	}

	private UserDto getTestUserDto(long id) {
		UserDto testUser = new UserDto(NAME, EMAIL, GROUP);
		testUser.setId(ID);
		testUser.setTags(TAGS);
		testUser.setHref(HREF);
		return testUser;
	}
}