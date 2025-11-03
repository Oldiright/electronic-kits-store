package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.exception.FileStorageException;
import com.example.electronic_kits_store.app.exception.InvalidFileException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String saveProductImage(Long productId, MultipartFile file, String category) {
        try {
            // Валідація
            validateImage(file);

            // Створюємо директорію для продукту
            String productDir = uploadDir + "/" + category + "/" + productId;
            Files.createDirectories(Paths.get(productDir));

            // Генеруємо унікальне ім'я
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            String extension = getFileExtension(originalFilename);
            String fileName = UUID.randomUUID().toString() + extension;

            // Зберігаємо файл
            Path filePath = Paths.get(productDir, fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Повертаємо відносний шлях
            return "/" + category + "/" + productId + "/" + fileName;

        } catch (IOException e) {
            throw new FileStorageException("Не вдалося зберегти файл", e);
        }
    }


    public Resource loadImage(String imagePath) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(imagePath).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new FileStorageException("Файл не знайдено: " + imagePath);
            }
        } catch (MalformedURLException e) {
            throw new FileStorageException("Невірний шлях до файлу", e);
        }
    }

    private void validateImage(MultipartFile file) {
        // Перевірка типу файлу
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new InvalidFileException("Тільки зображення дозволені");
        }
        // Перевірка розміру
        if (file.getSize() > 10 * 1024 * 1024) { // 10MB
            throw new InvalidFileException("Файл занадто великий (макс 10MB)");
        }
    }

    private String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf("."));
    }

    public void deleteImage(String imagePath) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(imagePath).normalize();
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new FileStorageException("Не вдалося видалити файл", e);
        }
    }

}
