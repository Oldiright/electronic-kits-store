package com.example.electronic_kits_store.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.lang.reflect.RecordComponent;

public class ValidRangeValidator implements ConstraintValidator<ValidRange, Object> {

    private String minField;
    private String maxField;
    private boolean allowEqual;

    @Override
    public void initialize(ValidRange constraintAnnotation) {
        this.minField = constraintAnnotation.minField();
        this.maxField = constraintAnnotation.maxField();
        this.allowEqual = constraintAnnotation.allowEqual();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return true;

        try {
            Object minValue = getFieldValue(value, minField);
            Object maxValue = getFieldValue(value, maxField);

            if (minValue == null || maxValue == null) {
                return true;
            }

            if (minValue instanceof Comparable<?> c1 && maxValue instanceof Comparable<?> c2) {
                @SuppressWarnings("unchecked")
                int comparison = ((Comparable<Object>) c1).compareTo(c2);
                return allowEqual ? comparison <= 0 : comparison < 0;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Object getFieldValue(Object obj, String fieldName) throws Exception {
        // Підтримка record
        if (obj.getClass().isRecord()) {
            for (RecordComponent rc : obj.getClass().getRecordComponents()) {
                if (rc.getName().equals(fieldName)) {
                    return rc.getAccessor().invoke(obj);
                }
            }
        }
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}