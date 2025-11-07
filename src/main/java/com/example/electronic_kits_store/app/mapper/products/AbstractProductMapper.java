package com.example.electronic_kits_store.app.mapper.products;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface AbstractProductMapper<E, D, R> {

    D toDto(E product);

    // pictureUrl не встановлюємо при створенні
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "pictureUrl", ignore = true),
            @Mapping(target = "category", ignore = true)
    })

    E toEntity(R request);

}
