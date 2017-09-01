package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@CacheConfig(cacheNames = "sessions")
public class SessionRepository {

    private static final Logger logger = LoggerFactory.getLogger(SessionRepository.class);

    @Cacheable(value="sessions", key="#sessionId")
    public Session findById(String sessionId) {
        logger.info("Loading session by id from the repository: " + sessionId);
        return new Session(sessionId, Calendar.getInstance().getTime());
    }
}
