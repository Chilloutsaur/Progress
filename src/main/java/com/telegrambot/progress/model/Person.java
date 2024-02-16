package com.telegrambot.progress.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "chat_id")
    private Long chatId;

    private String username;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_id")
    private List<Goal> goals;

    @OneToMany
    @JoinColumn(name = "chat_id")
    private List<Achievement> achievements;

    public void addGoals(List<Goal> goals) {
        this.goals.addAll(goals);
    }
}
