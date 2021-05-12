package com.jmik.storage;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * Converts group name to {@link UserGroup} enum and back.
 * @author jmik
 */
@Converter(autoApply = true)
public class GroupConverter implements AttributeConverter<UserGroup, String> {

	@Override
	public String convertToDatabaseColumn(UserGroup userGroup) {
		if (userGroup == null) {
			return null;
		}
		return userGroup.getGroupName();
	}

	@Override
	public UserGroup convertToEntityAttribute(String groupName) {
		if (groupName == null) {
			return null;
		}
		return Stream.of(UserGroup.values())
				.filter(group -> group.getGroupName().equals(groupName))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
