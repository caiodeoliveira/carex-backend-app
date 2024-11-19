package com.carex.backend.resource;

import com.carex.backend.entity.Terapy;
import com.carex.backend.services.TerapyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/terapy")
public class TerapyResource {

    @Autowired
    private TerapyService terapyService;

    @GetMapping(value = "/allTerapies")
    public ResponseEntity<List<Terapy>> getAllTerapies() {
        List<Terapy> terapies = this.terapyService.findAllTerapies();
        return ResponseEntity.ok().body(terapies);
    }

    @GetMapping(value = "/names")
    public ResponseEntity<List<String>> getAllTerapyNames() {
        List<String> names = this.terapyService.findAllTerapyNames();
        return ResponseEntity.ok().body(names);
    }

    @GetMapping(value = "/descriptions")
    public ResponseEntity<List<String>> getAllTerapyDescriptions() {
        List<String> descriptions = this.terapyService.findAllTerapyDescriptions();
        return ResponseEntity.ok().body(descriptions);
    }
}
