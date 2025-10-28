package com.example.electronic_kits_store.app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = VoltageRangeValidator.class) // Вказуємо клас, який містить логіку валідації
@Target({ TYPE }) // Застосовуємо до класу (DTO), а не до окремого поля
@Retention(RUNTIME)
public @interface VoltageRange {
    String message() default "Мінімальна напруга не може бути більшою за максимальну напругу.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}