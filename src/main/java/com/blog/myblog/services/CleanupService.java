package com.blog.myblog.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Clock;
import java.time.LocalDateTime;

import static javax.transaction.Transactional.TxType.MANDATORY;

@Service
@Slf4j
@Transactional (MANDATORY)
@RequiredArgsConstructor
public class CleanupService {

    private final Clock clock;

    private final AlertService alertService;
    private static final int ALERT_EXPIRATION_TIME = 7;

    public void cleanupExpiredAlerts(){
        LocalDateTime now = LocalDateTime.now(clock);
        log.debug("Now it is: <{}>",now);

        LocalDateTime expirationTime = now.minusDays(ALERT_EXPIRATION_TIME);
        alertService.deleteExpiredAlerts(expirationTime);
    }




}
