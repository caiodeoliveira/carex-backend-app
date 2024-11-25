package com.carex.backend.resource;

import com.carex.backend.dto.EmailDTO;
import com.carex.backend.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/email")
public class EmailResource {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDTO request) {
       String message = emailService.sendEmail(request.getTo(), request.getSubject(), request.getText());
       return ResponseEntity.ok().body(message);
    }
}
