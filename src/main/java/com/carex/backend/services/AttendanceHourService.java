package com.carex.backend.services;

import com.carex.backend.entity.AttendanceHour;
import com.carex.backend.repository.AttendanceHourRepository;
import com.carex.backend.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceHourService {

    @Autowired
    AttendanceHourRepository attendanceHourRepository;

    public List<AttendanceHour> findAllAvailableHours() {
        List<AttendanceHour> attendanceHours = new ArrayList<>();
                attendanceHourRepository.findAll().forEach(row -> {
                    if(row.getAvailable()) {
                        attendanceHours.add(row);
                    }
        });
        return attendanceHours;
    }

    public List<AttendanceHour> findAllAvailableAttendanceHourByDate(Date date) {
        DateUtil dateUtil = new DateUtil();
        String dateFormatted = dateUtil.convertDateToString(date);

        List<AttendanceHour> attendanceHourListFromDb = attendanceHourRepository.findAllByAttendanceDate(dateFormatted);
        List<AttendanceHour> availableAttendanceHourList = new ArrayList<>();

        for(AttendanceHour row : attendanceHourListFromDb){
            if(row.getAvailable()) {
                if(row.getAttendanceDate().getDate().equals(dateFormatted)){
                    availableAttendanceHourList.add(row);
                }
            }
        }

        return availableAttendanceHourList;
    }

    public void setNewProgrammingAttendanceHourAsUnavailable(String date, String hour) {

        AttendanceHour attendanceHourFromDb = this.attendanceHourRepository.findByAttendanceDateAndAttendanceHour(date, hour);

        attendanceHourFromDb.setAvailable(false);
        attendanceHourRepository.save(attendanceHourFromDb);

    }

    public void setPreviousProgrammingAttendanceHourAsAvailable(String date, String hour) {
        AttendanceHour previousAttendanceHour = this.attendanceHourRepository.findByAttendanceDateAndAttendanceHour(date, hour);
        previousAttendanceHour.setAvailable(true);
        this.attendanceHourRepository.save(previousAttendanceHour);
    }

}
