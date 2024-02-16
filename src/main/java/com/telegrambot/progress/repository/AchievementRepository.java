package com.telegrambot.progress.repository;

import com.telegrambot.progress.model.Achievement;
import com.telegrambot.progress.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
//    @Query(nativeQuery = true, value = "select * from goal where id in" +
//            "(select goal_id from achievement where achievement.person_chat_id = ?1 " +
//            "and date = ?2)")
//    List<Goal> getGoalsByChatIdAndDate(Long chatId, LocalDateTime date);

    @Query("select new Goal(g.id, g.goal) from Goal g where g.id in (select a.goal from Achievement a where a.person.chatId = ?1 and a.date = ?2)")
    List<Goal> getGoalsByChatIdAndDate(Long chatId, LocalDateTime date);
}
