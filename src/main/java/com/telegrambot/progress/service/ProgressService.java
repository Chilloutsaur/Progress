package com.telegrambot.progress.service;

import com.telegrambot.progress.model.Achievement;
import com.telegrambot.progress.model.Goal;
import com.telegrambot.progress.model.Person;
import com.telegrambot.progress.repository.AchievementDao;
import com.telegrambot.progress.repository.AchievementRepository;
import com.telegrambot.progress.repository.GoalRepository;
import com.telegrambot.progress.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgressService {
    private final AchievementRepository achievementRepository;
    private final PersonRepository personRepository;
    private final GoalRepository goalRepository;
    private final AchievementDao achievementDao;

    public void createPerson(Long chatId, String username) {
        if (personRepository.findById(chatId).isEmpty()) {
           personRepository.save(new Person(chatId, username, List.of(), List.of()));
        }
    }

    public void addGoals(Long chatId, List<Goal> goals) {
        Optional<Person> person = personRepository.findById(chatId);
        if (person.isPresent()) {
            person.get().addGoals(goals);
            personRepository.save(person.get());
        }
    }

    public void addAchievement(Long chatId, LocalDateTime date, Long goalId) {
        Optional<Person> person = personRepository.findById(chatId);
        Optional<Goal> goal = goalRepository.findById(goalId);
        if (person.isPresent() && goal.isPresent()) {
            achievementRepository.save(new Achievement(date,goal.get(), person.get()));
        }

    }

    public List<Goal> getCompletedGoalsByDate(Long chatId, LocalDateTime date) {
        return achievementRepository.getGoalsByChatIdAndDate(chatId, date);
    }
}
