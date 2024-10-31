package com.example.springbootconfigution.Controller;
import com.example.springbootconfigution.entity.Emil;
import com.example.springbootconfigution.service.EmailService;
import lombok.AllArgsConstructor;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmailController {
    private EmailService emilService;
    @PostMapping("/mail")
    public void sendEmail(@RequestBody Emil mail) {
        emilService.sendSimpleEmail(mail.getTo(),mail.getSubject(),mail.getBody());
    }
}