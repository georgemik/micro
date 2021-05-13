package com.jmik.storage;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User entity used to store user.
 * @author jmik
 */
@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@NotNull
	@Column(name = "NAME", nullable = false, unique = true)
	@Size(max = 255)
	private String name;
	@Column(name = "EMAIL")
	@Size(max = 255)
	private String email;
	@ElementCollection
	@CollectionTable(name = "GROUPS", joinColumns = @JoinColumn(name = "USER_ID"))
	@Column(name = "GRUPE")
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "USER_ID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@Convert(converter = GroupConverter.class)
	@Size(min = 1)
	Set<UserGroup> groups;
	@Column(name = "ACTIVE")
	private Boolean active = true;
	@ElementCollection
	@CollectionTable(name = "TAGS", joinColumns = @JoinColumn(name = "USER_ID"))
	@Column(name = "TAG")
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "USER_ID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<String> tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UserGroup> getGroups() {
		return new ArrayList<>(groups);
	}

	public void setGroups(List<UserGroup> groups) {
		this.groups = new HashSet<>(groups);
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<String> getTags() {
		return new ArrayList<>(tags);
	}

	public void setTags(List<String> tags) {
		this.tags = new HashSet<>(tags);
	}
}
