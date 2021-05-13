package com.jmik.restapi;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * DTO for user entity.
 * @author jmik
 */
@Introspected
public class UserDto {
	private Long id;
	@NotBlank
	@Size(max = 255)
	private String name;
	@NotBlank
	@Email
	@Size(max = 255)
	private String email;
	@GroupsConstraint
	private List<String> groups;
	private Boolean active = true;
	private List<@Size(max = 255) String> tags;
	private String href;

	public UserDto() {
	}

	public UserDto(String name, String email, List<String> groups) {
		this.name = name;
		this.email = email;
		this.groups = groups;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
