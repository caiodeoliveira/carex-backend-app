package com.carex.backend.resource;

import com.carex.backend.entity.AttendanceDate;
import com.carex.backend.entity.AttendanceHour;
import com.carex.backend.entity.ProfessionalSchedule;
import com.carex.backend.entity.Schedulling;
import com.carex.backend.services.AttendanceDateService;
import com.carex.backend.services.AttendanceHourService;
import com.carex.backend.services.ProfessionalScheduleService;
import com.carex.backend.services.SchedullingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/professionalschedule")
public class ProfessionalScheduleResource {

    @Autowired
    private ProfessionalScheduleService professionalScheduleService;

    @Autowired
    private AttendanceDateService attendanceDateService;

    @Autowired
    private AttendanceHourService attendanceHourService;

    @GetMapping(value = "/allschedules")
    public ResponseEntity<List<ProfessionalSchedule>> getAllProfessionalSchedule() {
        List<ProfessionalSchedule> professionalScheduleList = this.professionalScheduleService.findAllProfessionalSchedule();
        return ResponseEntity.ok().body(professionalScheduleList);
    }

    @GetMapping(value = "/date")
    public ResponseEntity<List<AttendanceDate>> getAllUnavailableDates() {
        List<AttendanceDate> fieldOptionList = this.attendanceDateService.findAllUnavailableDates();
        return ResponseEntity.ok().body(fieldOptionList);
    }

    @GetMapping(value = "/hour/{date}")
    public ResponseEntity<List<AttendanceHour>> getAllAvailableHours(@PathVariable Date date) {
        List<AttendanceHour> fieldOptionList = this.attendanceHourService.findAllAvailableAttendanceHourByDate(date);
        return ResponseEntity.ok().body(fieldOptionList);
    }

}
