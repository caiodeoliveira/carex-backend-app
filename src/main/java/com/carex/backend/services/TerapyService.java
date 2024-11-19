package com.carex.backend.services;

import com.carex.backend.entity.Terapy;
import com.carex.backend.repository.TerapyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TerapyService {

    @Autowired
    TerapyRepository terapyRepository;

    public List<Terapy> findAllTerapies() {
        return terapyRepository.findAll();
    }

    public List<String> findAllTerapyNames() {
        List<Terapy> terapyListFromDb = terapyRepository.findAll();
        List<String> names = terapyListFromDb.stream().map(t -> t.getName()).collect(Collectors.toList());
        return names;
    }

    public List<String> findAllTerapyDescriptions() {
        List<Terapy> terapyListFromDb = terapyRepository.findAll();
        List<String> descriptions = terapyListFromDb.stream().map(t -> t.getDescription()).collect(Collectors.toList());
        return descriptions;
    }
}
