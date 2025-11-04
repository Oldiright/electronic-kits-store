package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.dto.battery.UpdateBatteryRequest;
import com.example.electronic_kits_store.app.mapper.BatteryMapper;
import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.repository.BatteryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BatteryService extends AbstractSpecificProductService<Battery, BatteryDTO, CreateBatteryRequest, BatteryMapper> {

    public BatteryService(BatteryRepository repository, BatteryMapper mapper) {
        super(repository, mapper);
    }
    public BatteryDTO updateBattery(UpdateBatteryRequest updateBatteryRequest) {
        Battery battery = repository.findById(updateBatteryRequest.id()).orElseThrow();
        if(updateBatteryRequest.name() != null) {
            battery.setName(updateBatteryRequest.name());
        }
        if(updateBatteryRequest.cost() != null) {
            battery.setCost(updateBatteryRequest.cost());
        }
        if(updateBatteryRequest.manufacturer() != null) {
            battery.setManufacturer(updateBatteryRequest.manufacturer());
        }
        if(updateBatteryRequest.description() != null) {
            battery.setDescription(updateBatteryRequest.description());
        }
        if(updateBatteryRequest.rating() != null) {
            battery.setRating(updateBatteryRequest.rating());
        }
        if(updateBatteryRequest.nominalVoltage() != null) {
            battery.setNominalVoltage(updateBatteryRequest.nominalVoltage());
        }
        if(updateBatteryRequest.rating() != null) {
            battery.setRating(updateBatteryRequest.rating());
        }
        if(updateBatteryRequest.capacity() != null) {
            battery.setCapacity(updateBatteryRequest.capacity());
        }
        if(updateBatteryRequest.form() != null) {
            battery.setForm(mapper.stringToFormFactor(updateBatteryRequest.form()));
        }
        if(updateBatteryRequest.batteryTerminalDiameter() != null) {
            battery.setBatteryTerminalDiameter(updateBatteryRequest.batteryTerminalDiameter());
        }

        return mapper.toDto(repository.save(battery));
    }
}
