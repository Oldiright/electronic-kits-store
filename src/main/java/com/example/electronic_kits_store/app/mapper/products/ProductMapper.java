package com.example.electronic_kits_store.app.mapper.products;
import com.example.electronic_kits_store.app.dto.product.ProductDTO;
import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.projection.ProductProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(ProductProjection product);
    ProductDTO toDtoFromEntity(Product product);
}
