package com.telegrambot.progress.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Goal(String name) {
        this.name = name;
    }

    private String name;

    private String description;

    @ManyToOne
    private Person person;


}
