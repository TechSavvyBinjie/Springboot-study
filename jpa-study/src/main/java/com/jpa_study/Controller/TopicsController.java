package com.jpa_study.Controller;

import com.jpa_study.common.ResponseResult;
import com.jpa_study.mapper.TopicsDao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/yang")
public class TopicsController {
    private final TopicsDao topicsDao;

    @GetMapping("/topics")
    public ResponseResult getTopics(){
        return ResponseResult.builder()
                .code(200)
                .msg("成功")
                .data(topicsDao.findAll())
                .build();
    }

}
