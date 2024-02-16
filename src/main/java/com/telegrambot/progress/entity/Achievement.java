package com.telegrambot.progress.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@RequiredArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Timestamp achievementDate;

    @ManyToOne
    private Goal goal;

    @ManyToOne
    private Person person;

}
