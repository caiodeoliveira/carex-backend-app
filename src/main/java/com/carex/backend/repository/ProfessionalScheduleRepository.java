package com.carex.backend.repository;

import com.carex.backend.entity.ProfessionalSchedule;
import com.carex.backend.entity.Schedulling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalScheduleRepository extends JpaRepository<ProfessionalSchedule, Long> {
}
