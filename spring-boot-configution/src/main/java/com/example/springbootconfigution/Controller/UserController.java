package com.example.springbootconfigution.Controller;

import com.example.springbootconfigution.entity.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public String createUser(@Valid @RequestBody User user){
        return "用户有效";
    }

}
