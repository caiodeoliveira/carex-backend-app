package com.carex.backend.repository;

import com.carex.backend.entity.Programming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProgrammingRepository extends JpaRepository<Programming, Long> {

    @Query("SELECT p FROM Programming p WHERE p.attendanceCode = :code")
    Programming findByAttendanceCode(@Param("code") String code);
}
