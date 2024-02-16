package com.telegrambot.progress.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("/application.properties")
public class BotConfig {

    @Value("${bot.name}")
    String botName;
    @Value("${bot.token}")
    String token = "6462011994:AAEISME2NbhDTNTSyNRNoQs1-gGvuNwH6k0";

}
