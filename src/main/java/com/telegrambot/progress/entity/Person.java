package com.telegrambot.progress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id()
    @Column(name = "chat_id")
    private Long chatId;

    private String name;

    private LocalDateTime registeredAt;

    @OneToMany(mappedBy = "person",  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Goal> goals;

    public void addGoals(List<Goal> goals){
        this.goals.addAll(goals);
    }


}
