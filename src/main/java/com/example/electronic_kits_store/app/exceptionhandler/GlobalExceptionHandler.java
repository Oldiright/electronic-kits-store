package com.example.electronic_kits_store.app.exceptionhandler;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<String> handleUnrecognizedPropertyException(UnrecognizedPropertyException ex) {
        String error = String.format("Невідоме поле у вхідному запиті: '%s'. Перевірте назви полів.", ex.getKnownPropertyIds().toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        // 1. Збираємо помилки полів у Map: { "назва_поля": "повідомлення_помилки" }
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        fieldError -> (fieldError.getDefaultMessage() != null) ? fieldError.getDefaultMessage() : "Невідома помилка валідації"
                ));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
