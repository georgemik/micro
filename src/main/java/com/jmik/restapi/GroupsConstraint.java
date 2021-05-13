package com.jmik.restapi;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Constraint for group name validator.
 * @author jmik
 */
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GroupsConstraint {
	String message() default "The list of groups must contain valid group name element(s)";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
