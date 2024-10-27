package com.example.electronic_kits_store.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private int cost;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private byte rating;
    @Column(name = "picture")
    private String pictureUrl;
    @Column(name = "category")
    @Enumerated(EnumType.ORDINAL)
    private Category pruductCategory;


    public enum Category {
        BATTERY,
        BMS,
        INVERTER,
        POWER_BLOCK,
        WIRE,
        WIRE_LUG,
        OTHER
    }
}
