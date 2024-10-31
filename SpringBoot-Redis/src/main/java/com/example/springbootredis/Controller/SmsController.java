package com.example.springbootredis.Controller;

import com.example.springbootredis.Result.Result;
import com.example.springbootredis.Service.SmsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
@CrossOrigin
public class SmsController {
    @Resource
    private  SmsService smsService;

    @PostMapping("/send")
    public Result<Object> sendSms(@RequestParam("phone") String phone) {
        smsService.sendSms(phone);
        return Result.ok();
    }
}