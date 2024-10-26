package com.example.electronic_kits_store.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
}
