package com.example.myzhihuapi.controller;

import com.example.myzhihuapi.common.ResponseResult;
import com.example.myzhihuapi.entity.Special;
import com.example.myzhihuapi.service.SpecialService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1zhihu")
public class SpecialController {
    @Resource
    private SpecialService specialService;
@GetMapping("/all")
    public ResponseResult getAll(){
        List<Special> all=specialService.getAll();
        return ResponseResult.builder()
                .code(200)
                .msg("获取成功")
                .data(all)
                .build();
    }
    @GetMapping("/page")
    public ResponseResult getByPage(@RequestParam int limit,@RequestParam int offset){
    Map<String,Object> map = new HashMap<>();
        List<Special> specials=specialService.getByPage(limit, offset);
        map.put("specials",specials);
        map.put("total",specialService.getAll().size());
        return ResponseResult.builder()
                .code(200)
                .msg("获取成功")
                .data(map)
                .build();
    }
}
