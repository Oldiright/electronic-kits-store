package com.example.electronic_kits_store.app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ValidRangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRange {
    String message() default "Значення поля '{minField}' має бути менше за '{maxField}'";

    String minField();
    String maxField();

    boolean allowEqual() default false;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}