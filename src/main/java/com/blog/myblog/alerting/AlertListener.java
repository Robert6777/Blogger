package com.blog.myblog.alerting;

import com.blog.myblog.domain.alerts.Alert;
import com.blog.myblog.repositories.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlertListener {

    private final AlertRepository alertRepository;

    @EventListener
    public void handleArticleCommentedEvent(Alert alert){
        alertRepository.save(alert);
    }
}
