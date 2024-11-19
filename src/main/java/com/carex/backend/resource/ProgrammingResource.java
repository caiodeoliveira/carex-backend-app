package com.carex.backend.resource;

import com.carex.backend.dto.RescheduleProgrammingDTO;
import com.carex.backend.entity.Programming;
import com.carex.backend.entity.Schedulling;
import com.carex.backend.services.ProgrammingService;
import com.carex.backend.services.SchedullingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/programming")
public class ProgrammingResource {


    @Autowired
    private ProgrammingService programmingService;

    @PostMapping(value = "/saveformdata")
    public ResponseEntity<Programming> saveFormData(@RequestBody Programming programming) {
        Programming programmingSaved = this.programmingService.storeFormData(programming);
        return ResponseEntity.ok().body(programmingSaved);
    }

    @GetMapping(value = "/allprogrammings")
    public ResponseEntity<List<Programming>> getAllProgrammings() {
        List<Programming> programmingsList = this.programmingService.findAllProgrammings();
        return ResponseEntity.ok().body(programmingsList);
    }

    @GetMapping(value = "/programmingbycode")
    public ResponseEntity<Programming> getProgrammingByCode(@RequestParam String code) {
        Programming programming = this.programmingService.findProgrammingByCode(code);
        return ResponseEntity.ok().body(programming);
    }

//    @PatchMapping(value = "/reschedule")
//    public void updateProgrammingAttendanceHour(@RequestBody RescheduleProgrammingDTO rescheduleProgrammingDTO) throws ParseException {
//        this.programmingService.changeProgrammingAttendanceHour(rescheduleProgrammingDTO);
//    }

}
