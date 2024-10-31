package com.example.springboottask.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;
@Slf4j
public class ReminderTimer {
    public static void main(String[] args) {
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {

            @Override
            public void run() {
                log.info("休息一下，喝口水");
            }
        };
        timer.schedule(task,0,1000);
    }
}
