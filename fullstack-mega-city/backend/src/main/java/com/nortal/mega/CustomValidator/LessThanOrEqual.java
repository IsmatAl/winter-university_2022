package com.nortal.mega.CustomValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = LessThanOrEqualValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LessThanOrEqual {
    String message() default "This building cannot stake units more than the specified maximum";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}