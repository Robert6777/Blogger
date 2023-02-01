package com.blog.myblog.scheduledjobs;

import com.blog.myblog.services.CleanupService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class ExpiredAlertCleanupJob {

    private final CleanupService cleanupService;

    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public void cleanupExpiredAlerts(){
        cleanupService.cleanupExpiredAlerts();
    }
}
