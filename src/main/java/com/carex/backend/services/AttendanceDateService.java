package com.carex.backend.services;

import com.carex.backend.entity.AttendanceDate;
import com.carex.backend.entity.AttendanceHour;
import com.carex.backend.repository.AttendanceDateRepository;
import com.carex.backend.repository.AttendanceHourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceDateService {

    @Autowired
    AttendanceDateRepository attendanceDateRepository;

    @Autowired
    private AttendanceHourRepository attendanceHourRepository;

    public List<AttendanceDate> findAllUnavailableDates() {
        List<AttendanceDate> unavailableDatesFromDb = attendanceDateRepository.findAll();
        List<AttendanceDate> unavailableDates = new ArrayList<>();

        unavailableDatesFromDb.stream().forEach(row -> {
            if(!row.getAvailable()) {
                unavailableDates.add(row);
            }
        });

        return unavailableDates;
    }

    public void setAttendanceDateAvailability(String attendanceDate, List<AttendanceHour> attendanceHours) {
        boolean isAttendanceDateUnavailable = attendanceHours.stream().noneMatch(AttendanceHour::getAvailable);

        AttendanceDate attendanceDateFromDb = this.attendanceDateRepository.findByAttendanceDate(attendanceDate);

        if(isAttendanceDateUnavailable) {
            attendanceDateFromDb.setAvailable(false);
            attendanceDateRepository.save(attendanceDateFromDb);
        }
    }

    public void changeAttendanceDatesAvailability(List<String> attendanceDateList) {

        attendanceDateList.forEach(attendanceDate -> {
            List<AttendanceHour> attendanceHourList = attendanceHourRepository.findAllByAttendanceDate(attendanceDate);

            boolean isAttendanceDateUnavailable = attendanceHourList.stream().noneMatch(AttendanceHour::getAvailable);
            AttendanceDate attendanceDateFromDb = this.attendanceDateRepository.findByAttendanceDate(attendanceDate);

            if(isAttendanceDateUnavailable) {
                attendanceDateFromDb.setAvailable(false);
                attendanceDateRepository.save(attendanceDateFromDb);
            }
            else {
                attendanceDateFromDb.setAvailable(true);
                attendanceDateRepository.save(attendanceDateFromDb);
            }
        });
    }

}
