package com.telegrambot.progress.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("application.properties")
public class BotConfig {
    @Value("$bot.name")
    String botName;
    @Value("$token")
    String token;

}
