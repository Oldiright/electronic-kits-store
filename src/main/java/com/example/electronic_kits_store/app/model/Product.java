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
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq_id", allocationSize = 1)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private int cost;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private byte rating;
    @Column(name = "picture")
    private String pictureUrl;
    @Column(name = "category")
    @Enumerated(EnumType.ORDINAL)
    private Category productCategory;


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
