package com.carex.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(String to, String subject, String text) {

        try {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dcaioribeiro98@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        }
        catch (Exception e) {
            return "Erro ao tentar enviar email " + e.getCause().toString();
        }
        return "Email enviado com sucesso!";
    }
}
