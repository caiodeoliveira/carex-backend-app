package com.carex.backend.services;

import com.carex.backend.entity.ProfessionalSchedule;
import com.carex.backend.repository.ProfessionalScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalScheduleService {

    @Autowired
    ProfessionalScheduleRepository professionalScheduleRepository;

    public List<ProfessionalSchedule> findAllProfessionalSchedule() {
        return professionalScheduleRepository.findAll();
    }

}
