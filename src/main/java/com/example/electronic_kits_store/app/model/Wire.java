package com.example.electronic_kits_store.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "wire")
@PrimaryKeyJoinColumn(name = "wire_id")
public class Wire extends Product {
    public Wire() {
        super.setCategory(Category.WIRE);
    }
    @Column(name = "color")
    private String color;
    @Column(name = "cross_sectional_area")
    private Integer crossSectionArea;
    @Column(name = "insulation_material")
    private String insulationMaterial;
}
