package com.jmik.restapi;

import io.micronaut.context.annotation.Factory;
import io.micronaut.validation.validator.constraints.ConstraintValidator;

import javax.inject.Singleton;
import java.util.List;

import static com.jmik.restapi.ApiConstants.GROUPS_LIST;

/**
 * Validate REST API group names.
 * @author jmik
 */
@Factory
public class GroupsValidator {
	@Singleton
	ConstraintValidator<GroupsConstraint, List<String>> groupsValidator() {
		return (value, annotationMetadata, context) -> {
			if (value == null) {
				return false;
			}
			for (String group : value) {
				if (!GROUPS_LIST.contains(group)) {
					return false;
				}
			}
			return true;
		};
	}
}
