package com.example.electronic_kits_store.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Power_block")
@PrimaryKeyJoinColumn(name = "powerBlock_id")
public class PowerBlock extends Product {
    @Column(name = "min_voltage")
    private int minVoltage;
    @Column(name = "max_voltage")
    private int maxVoltage;
    @Column(name = "power")
    private int power;
}
