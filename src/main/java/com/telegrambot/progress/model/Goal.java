package com.telegrambot.progress.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goal;

    public Goal(Long id, String goal) {
        this.id = id;
        this.goal = goal;
    }

    public Goal(String goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goal='" + goal + '\'' +
                '}';
    }
}
