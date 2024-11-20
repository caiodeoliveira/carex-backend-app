package com.carex.backend.repository;

import com.carex.backend.entity.AttendanceHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AttendanceHourRepository extends JpaRepository<AttendanceHour, Long> {

    @Query("SELECT h from AttendanceHour h WHERE h.attendanceDate.date = :date")
    List<AttendanceHour> findAllByAttendanceDate(@Param("date") String date);

    @Query("SELECT h from AttendanceHour h WHERE h.attendanceDate.date = :date AND h.hour = :hour")
    AttendanceHour findByAttendanceDateAndAttendanceHour(@Param("date") String date, @Param("hour") String hour);
}
