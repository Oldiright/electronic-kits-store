package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.product.ProductDTO;
import com.example.electronic_kits_store.app.mapper.ProductMapper;
import com.example.electronic_kits_store.app.mapper.ProductMapperImpl;
import com.example.electronic_kits_store.app.projection.ProductProjection;
import com.example.electronic_kits_store.app.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.example.electronic_kits_store.app.model.Product.Category.BATTERY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
//    @Mock
//    private ProductRepository productRepository;
//
//    @InjectMocks
//    private ProductService productService;
//
//
//    @Test
//    void getById() {
//        // 1. Arrange (Підготовка)
//        ProductProjection testProduct = mock(ProductProjection.class);
//        when(testProduct.getName()).thenReturn("GoodBattery");
//        when(testProduct.getId()).thenReturn(778787878L);
//        when(testProduct.getCategory()).thenReturn(BATTERY);
//        when(productRepository.findProjectedById(anyLong())).thenReturn(testProduct);
//        // 2. Act
//        ProductDTO productFromDb = productService.findById(anyLong());
//
//        // 3. Assert
//        assertThat(productFromDb.name()).isEqualTo("GoodBattery");
//        assertThat(productFromDb.id()).isEqualTo(778787878L);
//        assertThat(productFromDb.category()).isEqualTo(BATTERY.toString());
//    }


}
