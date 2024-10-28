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
@Table(name = "BMS")
@PrimaryKeyJoinColumn(name = "BMS_id")
public class Bms extends Product {
    @Column(name = "max_power")
    private int maxPower;
    @Column(name = "balancer_type")
    private Balancer balancerType;
    @Column(name = "min_string_supported")
    private int minStringSupported;
    @Column(name = "max_string_supported")
    private int maxStringSupported;
    @Column(name = "bluetooth_availability")
    private boolean isBluetooth;

    public enum Balancer {
        ACTIVE,
        PASSIVE
    }
}
