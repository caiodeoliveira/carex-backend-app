package com.carex.backend.resource;

import com.carex.backend.entity.Schedulling;
import com.carex.backend.services.SchedullingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/schedulling")
public class SchedullingResource {

    @Autowired
    private SchedullingService schedullingService;

    @GetMapping(value = "/allschedules")
    public ResponseEntity<List<Schedulling>> getAllSchedulling() {
        List<Schedulling> scheduleList = this.schedullingService.findAllTerapies();
        return ResponseEntity.ok().body(scheduleList);
    }

    @GetMapping(value = "/allgenders")
    public ResponseEntity<List<String>> getAllGenders() {
        List<String> genderOptionList = this.schedullingService.getAllGenderOptions();
        return ResponseEntity.ok().body(genderOptionList);
    }

    @GetMapping(value = "/allpaymenttypeoptions")
    public ResponseEntity<List<String>> getAllPaymentTypeOptions() {
        List<String> paymentOptionList = this.schedullingService.getAllPaymentTypeOptions();
        return ResponseEntity.ok().body(paymentOptionList);
    }

    @GetMapping(value = "/allattendancecityoptions")
    public ResponseEntity<List<String>> getAllAttendanceCityOptions() {
        List<String> attendanceCityOptionList = this.schedullingService.getAllAttendanceCityOptions();
        return ResponseEntity.ok().body(attendanceCityOptionList);
    }

    @GetMapping(value = "/allpaymentoptions")
    public ResponseEntity<List<String>> getAllPaymentOptions() {
        List<String> paymentOptionList = this.schedullingService.getAllPaymentOptions();
        return ResponseEntity.ok().body(paymentOptionList);
    }

    @GetMapping(value = "/getschedullingfee/{city}")
    public ResponseEntity<String> getSchedullingFee(@PathVariable String city) {
        String schedullingFee = this.schedullingService.getSchedullingFeeByCity(city);
        return ResponseEntity.ok().body(schedullingFee);
    }

}
