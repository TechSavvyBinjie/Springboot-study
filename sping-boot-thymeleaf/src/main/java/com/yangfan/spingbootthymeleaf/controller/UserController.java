package com.yangfan.spingbootthymeleaf.controller;


import com.yangfan.spingbootthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
public class UserController {
    private List<User>  users=new ArrayList<>();
    @GetMapping("/userList")
    public String userList(Model model) {
        model.addAttribute("users",users);
        return "userList";
    }
    @PostMapping("/adduser")
    public String adduser(@RequestParam String username, String age, String email) {
        Long id = (long)(users.size() +1);
        User user =new User(id,username,age,email);
        users.add(user);
        return "redirect:/userList";
    }

}
