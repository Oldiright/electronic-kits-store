package com.example.electronic_kits_store.app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {
    String message() default "Номер телефону недійсний або має невірний формат.";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // Опціонально: регіон за замовчуванням (наприклад, для України "UA")
    String region() default "";


}
