package com.carex.backend.resources;

import com.carex.backend.entity.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @PostMapping("/save")
    public ResponseEntity<Payment> savePayment() {
        // Placeholder implementation
        Payment payment = new Payment();
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/success")
    public ResponseEntity<String> paymentSuccess() {
        return ResponseEntity.ok("Sucesso Parceiro!!!");
    }
}
