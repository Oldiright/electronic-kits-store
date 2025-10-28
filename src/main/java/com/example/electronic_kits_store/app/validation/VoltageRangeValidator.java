package com.example.electronic_kits_store.app.validation;

import com.example.electronic_kits_store.app.dto.powerblock.CreatePowerBlockRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VoltageRangeValidator implements ConstraintValidator<VoltageRange, CreatePowerBlockRequest> {

    @Override
    public boolean isValid(CreatePowerBlockRequest request, ConstraintValidatorContext context) {

        if (request.minVoltage() > request.maxVoltage()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("minVoltage")
                    .addConstraintViolation();

            return false;
        }
        return true;
    }
}