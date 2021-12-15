package com.example.spring4.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author dkotov
 * @since 14.12.2021
 */
@Component
public class Job {

    @Scheduled(cron = "1 * * * * *")
    public void job() {
        System.out.println(LocalDateTime.now());
    }
}
