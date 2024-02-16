package com.telegrambot.progress;

import com.telegrambot.progress.service.ProgressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProgressApplicationTests {
    @Autowired
    ProgressService progressService;

    @Test
    void contextLoads() {

    }

}
