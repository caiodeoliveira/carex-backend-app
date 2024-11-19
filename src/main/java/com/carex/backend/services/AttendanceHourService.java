package com.carex.backend.services;

import com.carex.backend.entity.AttendanceHour;
import com.carex.backend.entity.Programming;
import com.carex.backend.repository.AttendanceDateRepository;
import com.carex.backend.repository.AttendanceHourRepository;
import com.carex.backend.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public List<AttendanceHour> findAllAvailableAttendanceHourByDate(String date) {
        DateUtil dateUtil = new DateUtil();
        dateUtil.applyStringDatePattern(date);

        List<AttendanceHour> attendanceHourListFromDb = attendanceHourRepository.findByAttendanceDate(date);
        List<AttendanceHour> availableAttendanceHourList = new ArrayList<>();

        for(AttendanceHour row : attendanceHourListFromDb){
            if(row.getAvailable()) {
                if(row.getAttendanceDate().getDate().equals(date)){
                    availableAttendanceHourList.add(row);
                }
            }
        }

        return availableAttendanceHourList;
    }

    public void setNewProgrammingAttendanceHourAsUnavailable(Programming programming) {

        List<AttendanceHour> availableAttendanceHourListFromDb = findAllAvailableHours();

        availableAttendanceHourListFromDb.forEach(attendanceHourRow -> {
            if(programming.getAttendanceDate().equals(attendanceHourRow.getAttendanceDate().getDate())) {
                if(programming.getAttendanceHour().equals(attendanceHourRow.getHour())) {
                    attendanceHourRow.setAvailable(false);
                    attendanceHourRepository.save(attendanceHourRow);
                }
            }
        });
    }

}
