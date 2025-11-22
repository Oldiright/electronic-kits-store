package com.example.electronic_kits_store.app.mapper.customer;

import com.example.electronic_kits_store.app.dto.customer.CreateCustomerRequest;
import com.example.electronic_kits_store.app.dto.customer.CustomerDTO;
import com.example.electronic_kits_store.app.model.Customer;
import com.example.electronic_kits_store.app.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    //todo we need to hashed password,  check it late, maybe this method doesn't need
    Customer toEntity(CreateCustomerRequest createCustomerRequest);
    CustomerDTO toDto(Customer customer);
    default Long getProductIdFromProduct(Product product) {
        return product.getId();
    };
}
