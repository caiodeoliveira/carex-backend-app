package com.carex.backend.resource;

import com.carex.backend.entity.Insurance;
import com.carex.backend.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/insurance")
public class InsuranceResource {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping(value = "/allinsurances")
    public ResponseEntity<List<Insurance>> getAllTerapies() {
        List<Insurance> insuranceList = this.insuranceService.findAllInsurances();
        return ResponseEntity.ok().body(insuranceList);
    }
}
