package com.example.springbootconfigution.Controller;


import com.example.springbootconfigution.service.ConfigBackupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@AllArgsConstructor
public class ConfigBackupController{
    private final ConfigBackupService configBackupService;
    @GetMapping("/backup")
    public void backupConfig(){
        configBackupService.backupConfigFile();
    }}
