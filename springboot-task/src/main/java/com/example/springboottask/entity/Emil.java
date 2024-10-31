package com.example.springboottask.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("email_log")
public class Emil {
    private Long id;
    private String recipient;
    private String subject;
    private String content;
    private LocalDate sent_at;
}