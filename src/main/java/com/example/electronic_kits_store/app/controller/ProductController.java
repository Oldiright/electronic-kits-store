package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.product.ProductDTO;
import com.example.electronic_kits_store.app.service.FileStorageService;
import com.example.electronic_kits_store.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1/store/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final FileStorageService fileStorageService;
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));

    }
    @GetMapping("/all")
    public ResponseEntity<Page<ProductDTO>>findAll(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.findAll(pageable));

    }
    @GetMapping("/images/{category}/{productId}/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String category,
            @PathVariable Long productId,
            @PathVariable String filename) {

        String imagePath = category + "/" + productId + "/" + filename;
        Resource resource = fileStorageService.loadImage(imagePath);
        return  ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);

//        return ResponseEntity.ok()
//                .contentType(MediaType.IMAGE_JPEG)
//                .header(HttpHeaders.CACHE_CONTROL, "public, max-age=31536000") // Кешування на рік
//                .body(resource);
    }

}
