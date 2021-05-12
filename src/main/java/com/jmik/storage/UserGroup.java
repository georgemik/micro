package com.jmik.storage;

/**
 * User groups enumeration.
 * @author jmik
 */
public enum UserGroup {
	ADMINISTRATORS("ADMINISTRATORS"),
	AUDITORS("AUDITORS"),
	USERS("USERS"),
	GUESTS("GUESTS");

	private final String groupName;

	UserGroup(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}
}
