package com.example;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class SessionCheck {

    private static final List<String> SESSIONS = Arrays.asList(
            "111111111111111111111",
            "222222222222222222222",
            "333333333333333333333");

    private static final Logger logger = LoggerFactory.getLogger(SessionCheck.class);
    private final SessionRepository sessionRepository;

    private final Random random = new Random();

    @Scheduled(fixedDelay = 500)
    public void checkSession() {

        logger.info("Checking session: " + sessionRepository.findById(
                SESSIONS.get(this.random.nextInt(SESSIONS.size()))
        ));
    }
}
