package com.example.springbootconfigution.Controller;

import com.example.springbootconfigution.service.QrCodeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class QrCodeController {
    private final QrCodeService qrCodeService;

    @GetMapping("/qrcode")
    public void qrcode(){
        qrCodeService.generateCode();
    }
}
