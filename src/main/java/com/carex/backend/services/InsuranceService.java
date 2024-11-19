package com.carex.backend.services;

import com.carex.backend.entity.Insurance;
import com.carex.backend.entity.Terapy;
import com.carex.backend.repository.InsuranceRepository;
import com.carex.backend.repository.TerapyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    public List<Insurance> findAllInsurances() {
        return insuranceRepository.findAll();
    }

}
