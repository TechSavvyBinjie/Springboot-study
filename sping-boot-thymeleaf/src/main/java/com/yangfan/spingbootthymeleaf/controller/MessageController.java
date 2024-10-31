package com.yangfan.spingbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MessageController {
    @GetMapping("/message")
    public  String getMsg(Model model){
        //将“message"属性转换到视图
        model.addAttribute("message","Hello,Thymeleaf!");
        //返回的默认视图在templates中
        return "msg";
    }
}
