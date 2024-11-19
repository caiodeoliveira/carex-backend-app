package com.carex.backend.dto;

import java.util.Date;

public class RescheduleProgrammingDTO {

    private Date newAttendanceDate;
    private String newAttendanceHour;
    private String attendanceCode;

    public RescheduleProgrammingDTO() {
    }

    public RescheduleProgrammingDTO(Date newAttendanceDate, String newAttendanceHour, String attendanceCode) {
        this.newAttendanceDate = newAttendanceDate;
        this.newAttendanceHour = newAttendanceHour;
        this.attendanceCode = attendanceCode;
    }

    public Date getNewAttendanceDate() {
        return newAttendanceDate;
    }

    public void setNewAttendanceDate(Date newAttendanceDate) {
        this.newAttendanceDate = newAttendanceDate;
    }

    public String getNewAttendanceHour() {
        return newAttendanceHour;
    }

    public void setNewAttendanceHour(String newAttendanceHour) {
        this.newAttendanceHour = newAttendanceHour;
    }

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }
}
