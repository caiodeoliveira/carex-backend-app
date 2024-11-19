package com.carex.backend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_PROFESSIONAL_SCHEDULE")
public class ProfessionalSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "professional")
    private List<AttendanceDate> attendanceDate;

    @OneToMany(mappedBy = "professional")
    private List<AttendanceHour> attendanceHours;
}
