package com.jmik.restapi;

import com.google.common.collect.ImmutableBiMap;
import com.jmik.storage.UserGroup;

import java.util.List;
import java.util.stream.Collectors;

import static com.jmik.restapi.ApiConstants.*;

/**
 * Mapping {@link UserGroup} groups to API constants.
 * @author jmik
 */
class GroupMapper {
	private static final ImmutableBiMap<String, UserGroup> groupMap = ImmutableBiMap.<String, UserGroup>builder()
			.put(GROUP_ADMINS, UserGroup.ADMINISTRATORS)
			.put(GROUP_AUDITORS, UserGroup.AUDITORS)
			.put(GROUP_USERS, UserGroup.USERS)
			.put(GROUP_GUESTS, UserGroup.GUESTS)
			.build();

	static List<String> mapGroupToDto(List<UserGroup> groups) {
		return groups.stream().filter(g -> groupMap.inverse().containsKey(g)).map(g -> groupMap.inverse().get(g)).collect(Collectors.toList());
	}

	static List<UserGroup> mapDtoToGroup(List<String> apiGroups) {
		return apiGroups.stream().filter(groupMap::containsKey).map(groupMap::get).collect(Collectors.toList());
	}
}
