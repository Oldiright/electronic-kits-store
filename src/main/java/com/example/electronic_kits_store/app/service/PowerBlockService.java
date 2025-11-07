package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.powerblock.CreatePowerBlockRequest;
import com.example.electronic_kits_store.app.dto.powerblock.PowerBlockDTO;
import com.example.electronic_kits_store.app.dto.powerblock.UpdatePowerBlockRequest;
import com.example.electronic_kits_store.app.mapper.products.PowerBlockMapper;
import com.example.electronic_kits_store.app.model.PowerBlock;
import com.example.electronic_kits_store.app.repository.PowerBlockRepository;
import org.springframework.stereotype.Service;

@Service
public class PowerBlockService extends AbstractSpecificProductService<PowerBlock, PowerBlockDTO,
        CreatePowerBlockRequest, PowerBlockMapper>{

    public PowerBlockService(PowerBlockRepository repository, PowerBlockMapper mapper) {
        super(repository, mapper);
    }


    public PowerBlockDTO update(UpdatePowerBlockRequest updatePowerBlockRequest) {
        PowerBlock powerBlock = repository.findById(updatePowerBlockRequest.id()).orElseThrow();
        if(updatePowerBlockRequest.name() != null) {powerBlock.setName(updatePowerBlockRequest.name());}
        if(updatePowerBlockRequest.cost() != null) {powerBlock.setCost(updatePowerBlockRequest.cost());}
        if(updatePowerBlockRequest.manufacturer() != null) {powerBlock.setManufacturer(updatePowerBlockRequest.manufacturer());}
        if(updatePowerBlockRequest.description() != null) {powerBlock.setDescription(updatePowerBlockRequest.description());}
        if(updatePowerBlockRequest.rating() != null) {powerBlock.setRating(updatePowerBlockRequest.rating());}
        if(updatePowerBlockRequest.minVoltage() != null) {powerBlock.setMinVoltage(updatePowerBlockRequest.minVoltage());}
        if(updatePowerBlockRequest.maxVoltage() != null) {powerBlock.setMaxVoltage(updatePowerBlockRequest.maxVoltage());}
        if(updatePowerBlockRequest.power() != null) {powerBlock.setPower(updatePowerBlockRequest.power());}
        return mapper.toDto(repository.save(powerBlock));
    }
}
