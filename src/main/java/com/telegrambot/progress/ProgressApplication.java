package com.telegrambot.progress;

import com.telegrambot.progress.model.Goal;
import com.telegrambot.progress.service.ProgressService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class ProgressApplication {

    public static void main(String[] args) {
        ProgressService progressService = SpringApplication.run(ProgressApplication.class, args).getBean(ProgressService.class);
        progressService.createPerson(1L, "dego");
        progressService.addGoals(1L, List.of(new Goal("nihuya ne delat"), new Goal("ne delat nihuya "), new Goal("ne delat nihuya nikogda")));
        progressService.addAchievement(1L, LocalDateTime.of(2024,2,16,0,0), 1L);
        progressService.addAchievement(1L, LocalDateTime.of(2024,2,16,0,0), 2L);
        progressService.addAchievement(1L, LocalDateTime.of(2024,2,16,0,0), 3L);
        System.out.println(progressService.getCompletedGoalsByDate(1L, LocalDateTime.of(2024,2,16,0,0)));
    }

}
