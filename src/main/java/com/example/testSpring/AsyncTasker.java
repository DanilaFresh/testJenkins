package com.example.testSpring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class AsyncTasker {

    @Async()
//    @Scheduled(cron = "*/1 * * * * *")
    public void showThread(){
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
