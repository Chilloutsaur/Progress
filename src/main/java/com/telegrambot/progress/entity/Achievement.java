package com.telegrambot.progress.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
public class Achievement {

    public Achievement(Goal goal, Person person) {
        this.achievementDate = LocalDateTime.now();
        this.name = goal.getName();
        this.goal = goal;
        this.person = person;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime achievementDate;

    @OneToOne
    private Goal goal;

    @OneToOne
    private Person person;

}
