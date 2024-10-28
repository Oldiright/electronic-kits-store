package com.example.electronic_kits_store.app.model.projection;

public interface ProductProjection {
    Long getId();
    String getName();
    Double getCost();
    String getDescription();
    Integer getRating();
    String getPictureUrl();
    String getProductCategory();

}
