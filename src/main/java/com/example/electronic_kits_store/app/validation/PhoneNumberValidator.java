package com.example.electronic_kits_store.app.validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Documented;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    private String defaultRegion;


    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
       this.defaultRegion = constraintAnnotation.region();
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return true; // Обробляється @NotNull або @NotEmpty
        }
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        String region = phoneNumber.startsWith("+")?"ZZ": defaultRegion;
        try {
            Phonenumber.PhoneNumber numberProto = phoneNumberUtil.parse(phoneNumber, region);
            return phoneNumberUtil.isValidNumber(numberProto);
        } catch (NumberParseException e) {
        return false;
        }
    }
}
