package com.carex.backend.services;

import com.carex.backend.dto.RescheduleProgrammingDTO;
import com.carex.backend.entity.AttendanceDate;
import com.carex.backend.entity.AttendanceHour;
import com.carex.backend.entity.Programming;
import com.carex.backend.repository.AttendanceDateRepository;
import com.carex.backend.repository.AttendanceHourRepository;
import com.carex.backend.repository.ProgrammingRepository;
import com.carex.backend.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProgrammingService {

    @Autowired
    ProgrammingRepository programmingRepository;

    @Autowired
    AttendanceHourRepository attendanceHourRepository;

    @Autowired
    AttendanceDateRepository attendanceDateRepository;

    @Autowired
    AttendanceHourService attendanceHourService;

    @Autowired
    AttendanceDateService attendanceDateService;

    public List<Programming> findAllProgrammings() {
        return programmingRepository.findAll();
    }

    public Programming storeFormData(Programming programming) {

        DateUtil dateUtil = new DateUtil();
        programming.setAttendanceDate(dateUtil.applyStringDatePattern(programming.getAttendanceDate()));

        programmingRepository.save(programming);
        this.attendanceHourService.setNewProgrammingAttendanceHourAsUnavailable(programming.getAttendanceDate(), programming.getAttendanceHour());

        List<AttendanceHour> attendanceHourList = attendanceHourRepository.findAllByAttendanceDate(programming.getAttendanceDate());

        this.attendanceDateService.setAttendanceDateAvailability(programming.getAttendanceDate(), attendanceHourList);

        return programming;
    }

    public Programming findProgrammingByCode(String code) {return this.programmingRepository.findByAttendanceCode(code);}

    public void changeProgrammingAttendanceHour(RescheduleProgrammingDTO rescheduleProgrammingDTO) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        Programming programming = this.programmingRepository.findByAttendanceCode(rescheduleProgrammingDTO.getAttendanceCode());

        String newAttendanceDateConverted = formatter.format(rescheduleProgrammingDTO.getNewAttendanceDate());


      this.attendanceHourService.setNewProgrammingAttendanceHourAsUnavailable(newAttendanceDateConverted, rescheduleProgrammingDTO.getNewAttendanceHour());
      this.attendanceHourService.setPreviousProgrammingAttendanceHourAsAvailable(programming.getAttendanceDate(), programming.getAttendanceHour());

      List<String> attendanceDateList = List.of(programming.getAttendanceDate(), newAttendanceDateConverted);

      programming.setAttendanceDate(newAttendanceDateConverted);
      programming.setAttendanceHour(rescheduleProgrammingDTO.getNewAttendanceHour());
      this.programmingRepository.save(programming);

      this.attendanceDateService.changeAttendanceDatesAvailability(attendanceDateList);

    }

}
