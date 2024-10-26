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
@PrimaryKeyJoinColumn(name = "inverterId")
@Table(name = "inverter")
public class Inverter extends Product {
    @Column(name = "power")
    private int power;
    @Column(name = "input_voltage")
    private InputVoltage inputVoltage;

    public enum InputVoltage {
        LOW {
            @Override
            public String toString() {
                return "12";
            }
         },
         HIGH {
             @Override
             public String toString() {
                 return "24";
             }
         }
    }
}
