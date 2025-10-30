package com.example.electronic_kits_store.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Table(name = "product", uniqueConstraints = {
        @UniqueConstraint(name = "uq_product_name", columnNames = "name")
})
@EntityListeners(AuditingEntityListener.class)
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq_id", allocationSize = 1)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
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
    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;
    @Column(name = "is_available")
    private Boolean isAvailable = true;
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @LastModifiedDate
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public enum Category {
        BATTERY,
        BMS,
        INVERTER,
        POWER_BLOCK,
        WIRE,
        WIRE_LUG,
        OTHER
    }

    protected void setCategory(Category category) {
        this.category = category;
    }
}
