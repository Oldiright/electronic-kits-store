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
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Table(name = "product")
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq_id", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private Byte rating;
    @Column(name = "picture")
    private String pictureUrl;
    @Column(name = "category")
    @Enumerated(EnumType.ORDINAL)
    private Category category;


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
