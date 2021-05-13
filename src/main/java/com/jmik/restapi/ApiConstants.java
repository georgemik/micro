package com.jmik.restapi;

import com.google.common.collect.ImmutableList;

/**
 * Constants used in REST API.
 * @author jmik
 */
class ApiConstants {
	static final String GROUP_ADMINS = "administrators";
	static final String GROUP_AUDITORS = "auditors";
	static final String GROUP_USERS = "users";
	static final String GROUP_GUESTS = "guests";

	static final ImmutableList<String> GROUPS_LIST = ImmutableList.<String>builder()
			.add(GROUP_ADMINS).add(GROUP_AUDITORS).add(GROUP_USERS).add(GROUP_GUESTS)
			.build();
}
