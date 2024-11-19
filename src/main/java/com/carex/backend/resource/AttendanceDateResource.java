package com.carex.backend.resource;

import com.carex.backend.entity.AttendanceDate;
import com.carex.backend.services.AttendanceDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/attendancedate")
public class AttendanceDateResource {

    @Autowired
    private AttendanceDateService attendanceDateService;

    @GetMapping(value = "/alldatesnotavailable")
    public ResponseEntity<List<AttendanceDate>> getAllProfessionalSchedule() {
        List<AttendanceDate> notAvailableDateList = this.attendanceDateService.findAllUnavailableDates();
        return ResponseEntity.ok().body(notAvailableDateList);
    }

}
