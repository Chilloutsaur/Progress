package com.telegrambot.progress.repository;

import com.telegrambot.progress.model.Achievement;
import com.telegrambot.progress.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    @Query(nativeQuery = true, value = "select * from goal where id in" +
            "(select goal_id from achievement where achievement.chat_id = ?1 " +
            "and date = ?2)")
    List<Goal> getGoalsByChatIdAndDate(Long chatId, LocalDateTime date);
    @Query(nativeQuery = true, value = "insert into achievement values (chat_id = ?1, date = ?2, goal_id = ?3)")
    void add(Long chatId, LocalDateTime date, Long goalId);
}
