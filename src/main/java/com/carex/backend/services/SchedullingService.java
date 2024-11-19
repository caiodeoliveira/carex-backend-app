package com.carex.backend.services;

import com.carex.backend.entity.Programming;
import com.carex.backend.entity.Schedulling;
import com.carex.backend.enums.AttendanceCityEnum;
import com.carex.backend.enums.GenderEnum;
import com.carex.backend.enums.PaymentEnum;
import com.carex.backend.enums.PaymentTypeEnum;
import com.carex.backend.repository.SchedullingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchedullingService {

    @Autowired
    SchedullingRepository schedullingRepository;

    public List<Schedulling> findAllTerapies() {
        return schedullingRepository.findAll();
    }

    public List<String> getAllGenderOptions() {
        List<String> genderOptions = new ArrayList<>();

        for(GenderEnum genderItem : GenderEnum.values()) {
            genderOptions.add(genderItem.getGender());
        }
        return genderOptions;
    }

    public List<String> getAllPaymentTypeOptions() {
        List<String> paymentOptionsList = new ArrayList<>();

        for(PaymentTypeEnum typeItem : PaymentTypeEnum.values()) {
            paymentOptionsList.add(typeItem.getPaymentType());
        }
        return paymentOptionsList;
    }

    public List<String> getAllAttendanceCityOptions() {
        List<String> attendanceCityOptionsList = new ArrayList<>();

        for(AttendanceCityEnum cityItem : AttendanceCityEnum.values()) {
            attendanceCityOptionsList.add(cityItem.getCity());
        }
        return attendanceCityOptionsList;
    }

    public List<String> getAllPaymentOptions() {
        List<String> paymentOptionsList = new ArrayList<>();

        for(PaymentEnum paymentItem : PaymentEnum.values()) {
            paymentOptionsList.add(paymentItem.getPayment());
        }
        return paymentOptionsList;
    }

    public String getSchedullingFeeByCity(String city) {
        String schedullingFee = "";
        for(AttendanceCityEnum cityItem : AttendanceCityEnum.values()) {
            if(cityItem.getCity().equals(city)) {
                schedullingFee = cityItem.getFee();
                return schedullingFee;
            }
        }
        return "";
    }

}
