package com.carex.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_ATTENDANCE_DATE")
public class AttendanceDate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String date;

    private Boolean available;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "professional_id")
    private ProfessionalSchedule professional;

    public AttendanceDate() {}

    public AttendanceDate(Long id, String date, Boolean available, ProfessionalSchedule professional) {
        this.id = id;
        this.date = date;
        this.available = available;
        this.professional = professional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public ProfessionalSchedule getProfessional() {
        return professional;
    }

    public void setProfessional(ProfessionalSchedule professional) {
        this.professional = professional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceDate that = (AttendanceDate) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
