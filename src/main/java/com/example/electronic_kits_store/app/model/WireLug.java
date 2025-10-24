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
@Table(name = "wire_lug")
@PrimaryKeyJoinColumn(name = "wire_lug_id")
public class WireLug extends Product {
    @Column(name = "wire_cross_sectional_area")
    private Integer wireCrossSectionArea;
    @Column(name = "terminal_diameter")
    private Integer terminalDiameter;
    @Column(name = "material")
    private String material;
}
