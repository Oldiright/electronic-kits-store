package com.example.electronic_kits_store.app.mapper;
import com.example.electronic_kits_store.app.dto.ProductDTO;
import com.example.electronic_kits_store.app.projection.ProductProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(ProductProjection product);
}
