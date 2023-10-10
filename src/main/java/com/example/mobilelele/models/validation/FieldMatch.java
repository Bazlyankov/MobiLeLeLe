package com.example.mobilelele.models.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UniqueUserEmailValidator.class)
public @interface FieldMatchValidator {


    String first();
    String second();

    String message() default "The two fields should have matching values";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
