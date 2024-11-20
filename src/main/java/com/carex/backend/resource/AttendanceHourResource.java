package com.carex.backend.resource;

import com.carex.backend.entity.AttendanceHour;
import com.carex.backend.entity.ProfessionalSchedule;
import com.carex.backend.services.AttendanceHourService;
import com.carex.backend.services.ProfessionalScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/attendancehour")
public class AttendanceHourResource {

    @Autowired
    AttendanceHourService attendanceHourService;

    @GetMapping(value = "/allhoursavailable/{date}")
    public ResponseEntity<List<AttendanceHour>> getAllProfessionalSchedule(@PathVariable Date date) {
        List<AttendanceHour> professionalScheduleList = this.attendanceHourService.findAllAvailableAttendanceHourByDate(date);
        return ResponseEntity.ok().body(professionalScheduleList);
    }

}
