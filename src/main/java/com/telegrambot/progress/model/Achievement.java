package com.telegrambot.progress.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name = "goal_id", referencedColumnName = "id")
    private Goal goal;

    @ManyToOne
    private Person person;

    public Achievement(LocalDateTime date, Goal goal, Person person) {
        this.date = date;
        this.goal = goal;
        this.person = person;
    }
}
