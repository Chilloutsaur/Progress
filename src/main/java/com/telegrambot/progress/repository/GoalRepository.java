package com.telegrambot.progress.repository;

import com.telegrambot.progress.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
