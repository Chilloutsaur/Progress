package com.telegrambot.progress.service;

import com.telegrambot.progress.entity.Achievement;
import com.telegrambot.progress.entity.Goal;
import com.telegrambot.progress.entity.Person;
import com.telegrambot.progress.repository.AchievementRepository;
import com.telegrambot.progress.repository.GoalRepository;
import com.telegrambot.progress.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProgressService {

    @Autowired
    AchievementRepository achievementRepository;
    @Autowired
    GoalRepository goalRepository;
    @Autowired
    PersonRepository personRepository;

    public void createPerson(Long chatId, String username) {
        if (personRepository.findById(chatId).isEmpty()) {
            personRepository.save(new Person(chatId, username, LocalDateTime.now(), List.of()));
        } else {
            System.out.println("Person already exists");
        }
    }

    public void addGoal(long chatId, List<Goal> goals) {
        Optional<Person> person = personRepository.findById(chatId);
        person.ifPresent(p -> {
            p.addGoals(goals);
            personRepository.save(p);
        });

    }

    public void addAchievement(Long chatId, Long goalId) {
        Optional<Person> person = personRepository.findById(chatId);
        Optional<Goal> goal = goalRepository.findById(goalId);
        if (person.isPresent() && goal.isPresent()) {
            achievementRepository.save(new Achievement(goal.get(), person.get()));
        }
    }


}
