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
import java.util.List;

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
        this.attendanceHourService.setNewProgrammingAttendanceHourAsUnavailable(programming);


        List<AttendanceHour> attendanceHourList = attendanceHourRepository.findByAttendanceDate(programming.getAttendanceDate());
        this.attendanceDateService.setAttendanceDateAvailability(programming.getAttendanceDate(), attendanceHourList);

        this.checkAttendanceDateAvailability(programming.getAttendanceDate(), attendanceHourList);

        return programming;
    }

    public Programming findProgrammingByCode(String code) {return this.programmingRepository.findByAttendanceCode(code);}

//    public void changeProgrammingAttendanceHour(RescheduleProgrammingDTO rescheduleProgrammingDTO) throws ParseException {}

    public void checkAttendanceDateAvailability(String attendanceDate, List<AttendanceHour> attendanceHourList) {

        AttendanceDate attendanceDateFromDb = this.attendanceDateRepository.findByAttendanceDate(attendanceDate);

        boolean isAllHoursUnavailable = attendanceHourList.stream().noneMatch(AttendanceHour::getAvailable);

        if(!isAllHoursUnavailable) {
            if(!attendanceDateFromDb.getAvailable()) {
                attendanceDateFromDb.setAvailable(true);
                attendanceDateRepository.save(attendanceDateFromDb);
            }
        }
        else {
            attendanceDateFromDb.setAvailable(false);
            attendanceDateRepository.save(attendanceDateFromDb);
        }
    }

}
