package com.carex.backend.repository;

import com.carex.backend.entity.AttendanceDate;
import com.carex.backend.entity.AttendanceHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AttendanceDateRepository extends JpaRepository<AttendanceDate, Long> {
    @Query("SELECT d from AttendanceDate d WHERE d.date = :date")
    AttendanceDate findByAttendanceDate(@Param("date") String date);
}
