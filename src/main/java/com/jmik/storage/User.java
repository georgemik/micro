package com.jmik.storage;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
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
	@Column(name = "USER_GROUP")
	@Size(max = 255)
	private String group;
	@Column(name = "ACTIVE")
	private Boolean active = true;
	@ElementCollection()
	@CollectionTable(name = "TAGS", joinColumns = @JoinColumn(name = "USER_ID"))
	@Column(name = "TAG")
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "USER_ID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<String> tags;

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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
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
}
