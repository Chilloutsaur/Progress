package com.telegrambot.progress.repository;

import com.telegrambot.progress.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementJpaRepository extends JpaRepository<Achievement, Long> {

}
