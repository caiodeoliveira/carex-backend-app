package com.carex.backend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_PROGRAMMING")
public class Programming implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String name;
    private String attendanceDate;
    private String attendanceHour;
    private String patientGender;
    private String patientPhoneNumber;
    private String paymentType;
    @Column(nullable = true)
    private String healthInsurance;
    private String attendanceLocation;
    @Column(nullable = true)
    private String attendanceCity;
    @Column(nullable = true)
    private String attendanceAddress;
    @Column(nullable = false)
    private String attendanceCode;

    public Programming() {}

    public Programming(String status, String name, String attendanceDate, String attendanceHour, String patientGender, String patientPhoneNumber, String paymentType, String healthInsurance, String attendanceLocation, String attendanceCity, String attendanceAddress, String attendanceCode) {
        this.status = status;
        this.name = name;
        this.attendanceDate = attendanceDate;
        this.attendanceHour = attendanceHour;
        this.patientGender = patientGender;
        this.patientPhoneNumber = patientPhoneNumber;
        this.paymentType = paymentType;
        this.healthInsurance = healthInsurance;
        this.attendanceLocation = attendanceLocation;
        this.attendanceCity = attendanceCity;
        this.attendanceAddress = attendanceAddress;
        this.attendanceCode = attendanceCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getAttendanceHour() {
        return attendanceHour;
    }

    public void setAttendanceHour(String attendanceHour) {
        this.attendanceHour = attendanceHour;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getAttendanceLocation() {
        return attendanceLocation;
    }

    public void setAttendanceLocation(String attendanceLocation) {
        this.attendanceLocation = attendanceLocation;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public String getAttendanceCity() {
        return attendanceCity;
    }

    public void setAttendanceCity(String attendanceCity) {
        this.attendanceCity = attendanceCity;
    }

    public String getAttendanceAddress() {
        return attendanceAddress;
    }

    public void setAttendanceAddress(String attendanceAddress) {
        this.attendanceAddress = attendanceAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programming schedulling = (Programming) o;
        return Objects.equals(id, schedulling.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
