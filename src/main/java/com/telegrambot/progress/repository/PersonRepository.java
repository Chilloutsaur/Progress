package com.telegrambot.progress.repository;

import com.telegrambot.progress.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
