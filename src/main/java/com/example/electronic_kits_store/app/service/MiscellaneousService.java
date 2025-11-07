package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.miscellaneous.CreateMiscellaneousRequest;
import com.example.electronic_kits_store.app.dto.miscellaneous.MiscellaneousDTO;
import com.example.electronic_kits_store.app.dto.miscellaneous.UpdateMiscellaneousRequest;
import com.example.electronic_kits_store.app.mapper.products.MiscellaneousMapper;
import com.example.electronic_kits_store.app.model.Miscellaneous;
import com.example.electronic_kits_store.app.repository.MiscellaneousRepository;
import org.springframework.stereotype.Service;

@Service
public class MiscellaneousService extends AbstractSpecificProductService<Miscellaneous, MiscellaneousDTO,
        CreateMiscellaneousRequest, MiscellaneousMapper>{
    public MiscellaneousService(MiscellaneousRepository repository, MiscellaneousMapper mapper) {
        super(repository, mapper);
    }
    public MiscellaneousDTO update(UpdateMiscellaneousRequest updateMiscellaneousRequest) {
        Miscellaneous miscellaneous = repository.findById(updateMiscellaneousRequest.id()).orElseThrow();
        if(updateMiscellaneousRequest.name() != null) {miscellaneous.setName(updateMiscellaneousRequest.name());}
        if(updateMiscellaneousRequest.cost() != null) {miscellaneous.setCost(updateMiscellaneousRequest.cost());}
        if(updateMiscellaneousRequest.manufacturer() != null) {miscellaneous.setManufacturer(updateMiscellaneousRequest.manufacturer());}
        if(updateMiscellaneousRequest.description() != null) {miscellaneous.setDescription(updateMiscellaneousRequest.description());}
        if(updateMiscellaneousRequest.rating() != null) {miscellaneous.setRating(updateMiscellaneousRequest.rating());}
        if(updateMiscellaneousRequest.otherInfo() != null) {miscellaneous.setOtherInfo(updateMiscellaneousRequest.otherInfo());}
        return mapper.toDto(repository.save(miscellaneous));
    }
}
