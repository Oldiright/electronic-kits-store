package com.example.electronic_kits_store.app.service;
import com.example.electronic_kits_store.app.model.Miscellaneous;
import com.example.electronic_kits_store.app.repository.MiscellaneousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiscellaneousService {

    private final MiscellaneousRepository miscellaneousRepository;

    public List<Miscellaneous> findAll() {
        return miscellaneousRepository.findAll();
    }


}
