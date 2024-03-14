package com.telegrambot.progress;

import com.telegrambot.progress.entity.Goal;
import com.telegrambot.progress.service.ProgressService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories()
public class ProgressApplication {

    @GetMapping
    public static void main(String[] args) {
            ProgressService progressService = SpringApplication.run(ProgressApplication.class, args).getBean(ProgressService.class);
            progressService.createPerson(1L, "username");
            progressService.addGoal(1L, List.of(new Goal("GoalName"), new Goal("GoalName")));
            progressService.addAchievement(1L, 1L);
            progressService.addAchievement(1L,  2L);
        }

    }

