package com.carex.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_ATTENDANCE_HOUR")
public class AttendanceHour implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String hour;

    private Boolean available;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "professional_id")
    private ProfessionalSchedule professional;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "date_pair", referencedColumnName = "date")
    private AttendanceDate attendanceDate;

    public AttendanceHour() {
    }

    public AttendanceHour(Long id, String hour, Boolean available, ProfessionalSchedule professional, AttendanceDate attendanceDate) {
        this.id = id;
        this.hour = hour;
        this.available = available;
        this.professional = professional;
        this.attendanceDate = attendanceDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public ProfessionalSchedule getProfessional() {
        return professional;
    }

    public void setProfessional(ProfessionalSchedule professional) {
        this.professional = professional;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public AttendanceDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(AttendanceDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceHour that = (AttendanceHour) o;
        return Objects.equals(id, that.id) && Objects.equals(hour, that.hour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hour);
    }
}
