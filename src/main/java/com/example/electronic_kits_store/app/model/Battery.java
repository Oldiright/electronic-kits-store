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
@Table(name = "battery")
@PrimaryKeyJoinColumn(name = "battery_id")
public class Battery extends Product {
    public Battery() {
        super.setCategory(Category.BATTERY);
    }
    @Column(name = "nominal_voltage")
    private Integer nominalVoltage;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "form")
    private FormFactor form;
    @Column(name = "battery_terminal_diameter")
    private Integer batteryTerminalDiameter;

    public enum FormFactor {
        PRISMATIC,
        CYLINDRICAL
    }
}
