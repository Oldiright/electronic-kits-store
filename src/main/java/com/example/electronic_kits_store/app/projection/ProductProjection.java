package com.example.electronic_kits_store.app.projection;

import com.example.electronic_kits_store.app.model.Product;

import java.math.BigDecimal;

public interface ProductProjection {
    Long getId();
    String getName();
    BigDecimal getCost();
    String getManufacturer();
    String getDescription();
    byte getRating();
    String getPictureUrl();
    Product.Category getCategory();

}
