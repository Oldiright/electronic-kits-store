package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.inverter.CreateInverterRequest;
import com.example.electronic_kits_store.app.dto.inverter.InverterDTO;
import com.example.electronic_kits_store.app.dto.inverter.UpdateInverterRequest;
import com.example.electronic_kits_store.app.mapper.InverterMapper;
import com.example.electronic_kits_store.app.model.Inverter;
import com.example.electronic_kits_store.app.repository.InverterRepository;
import org.springframework.stereotype.Service;

@Service
public class InverterService extends AbstractSpecificProductService<Inverter, InverterDTO, CreateInverterRequest, InverterMapper> {
    public InverterService(InverterRepository repository, InverterMapper mapper) {
        super(repository, mapper);
    }
    public InverterDTO update(UpdateInverterRequest updateInverterRequest) {
        Inverter inverter = repository.findById(updateInverterRequest.id()).orElseThrow();
        if(updateInverterRequest.name() != null) {inverter.setName(updateInverterRequest.name());}
        if(updateInverterRequest.cost() != null) {inverter.setCost(updateInverterRequest.cost());}
        if(updateInverterRequest.manufacturer() != null) {inverter.setManufacturer(updateInverterRequest.manufacturer());}
        if(updateInverterRequest.description() != null) {inverter.setDescription(updateInverterRequest.description());}
        if(updateInverterRequest.rating() != null) {inverter.setRating(updateInverterRequest.rating());}
        if(updateInverterRequest.power() != null) {inverter.setPower(updateInverterRequest.power());}
        if(updateInverterRequest.inputVoltage() != null) {inverter.setInputVoltage(mapper.convertInputVoltage(updateInverterRequest.inputVoltage()));}
        return mapper.toDto(repository.save(inverter));
    }
}
