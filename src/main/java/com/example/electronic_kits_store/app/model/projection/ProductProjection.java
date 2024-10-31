package com.example.electronic_kits_store.app.model.projection;

import com.example.electronic_kits_store.app.model.Product;

public interface ProductProjection {
    Long getId();
    String getName();
    int getCost();
    String getManufacturer();
    String getDescription();
    byte getRating();
    String getPictureUrl();
    Product.Category getProductCategory();

}
