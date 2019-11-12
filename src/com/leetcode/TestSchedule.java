package com.leetcode;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestSchedule {
    public static void main(String[] args) {
        System.out.println("==========");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("----------");
            }
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(task, 0,1, TimeUnit.SECONDS);
    }
}
