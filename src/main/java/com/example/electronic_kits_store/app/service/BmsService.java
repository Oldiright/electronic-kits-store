package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.bms.BmsDTO;
import com.example.electronic_kits_store.app.dto.bms.CreateBmsRequest;
import com.example.electronic_kits_store.app.dto.bms.UpdateBmsRequest;
import com.example.electronic_kits_store.app.mapper.BmsMapper;
import com.example.electronic_kits_store.app.model.Bms;
import com.example.electronic_kits_store.app.repository.BmsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BmsService extends AbstractSpecificProductService<Bms, BmsDTO, CreateBmsRequest, BmsMapper> {
    public BmsService(BmsRepository repository, BmsMapper mapper) {
        super(repository, mapper);
    }
    public BmsDTO update(UpdateBmsRequest updateBmsRequest) {
        Bms bms = repository.findById(updateBmsRequest.id()).orElseThrow();
        if(updateBmsRequest.name() != null) {bms.setName(updateBmsRequest.name());}
        if(updateBmsRequest.cost() != null) {bms.setCost(updateBmsRequest.cost());}
        if(updateBmsRequest.manufacturer() != null) {bms.setManufacturer(updateBmsRequest.manufacturer());}
        if(updateBmsRequest.description() != null) {bms.setDescription(updateBmsRequest.description());}
        if(updateBmsRequest.rating() != null) {bms.setRating(updateBmsRequest.rating());}
        if(updateBmsRequest.maxPower() != null) {bms.setMaxPower(updateBmsRequest.maxPower());}
        if(updateBmsRequest.balancerType() != null) {bms.setBalancerType(Bms.Balancer.valueOf(updateBmsRequest.balancerType()));}
        if(updateBmsRequest.minStringSupported() != null) {bms.setMinStringSupported(updateBmsRequest.minStringSupported());}
        if(updateBmsRequest.maxStringSupported() != null) {bms.setMaxStringSupported(updateBmsRequest.maxStringSupported());}
        if(updateBmsRequest.isBluetooth() != null) {bms.setIsBluetooth(updateBmsRequest.isBluetooth());}
        return mapper.toDto(repository.save(bms));
    }
}
