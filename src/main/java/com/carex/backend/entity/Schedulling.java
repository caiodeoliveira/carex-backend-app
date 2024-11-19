package com.carex.backend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHEDULLING")
public class Schedulling implements Serializable {

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
    private String attendanceLocation;
    @Column(nullable = true)
    private String healthInsurance;
    @Column(nullable = true)
    private String attendanceCity;
    @Column(nullable = true)
    private String attendanceAddress;

    public Schedulling() {}

    public Schedulling(String name, String status, String date, String hour, String gender, String phoneNumber, String paymentType, String location, String insurance, String city, String address) {
        this.status = status;
        this.name = name;
        this.attendanceDate = date;
        this.attendanceHour = hour;
        this.patientGender = gender;
        this.patientPhoneNumber = phoneNumber;
        this.paymentType = paymentType;
        this.attendanceLocation = location;
        this.healthInsurance = insurance;
        this.attendanceCity = city;
        this.attendanceAddress = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedulling schedulling = (Schedulling) o;
        return Objects.equals(id, schedulling.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
