package com.example.testSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class TaskExecConfig {

    @Bean
    public Executor myExec() {
        return Executors.newFixedThreadPool(1);
    }
}
