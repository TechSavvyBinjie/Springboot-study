package quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quickstart.enums.RequestType;
import quickstart.service.CustomerService;

@RestController
@RequestMapping("/v1")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @GetMapping("/{type}")
    public String handleRequest(@PathVariable RequestType type){
        return customerService.handleREquest(type);
    }

}
