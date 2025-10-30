package com.example.electronic_kits_store.app.exception;

public class FileStorageException extends RuntimeException {
    public FileStorageException(String message, Exception e) {super(message, e);}
    public FileStorageException(String message) {super(message);}
}
