package quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quickstart.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/v3")
public class UsersController {
    @Resource
    private UserService userService;
    @GetMapping("/adults")
    public List<String> getAdultUserNames(){
        return userService.getAdultUserNames();
    }
}
