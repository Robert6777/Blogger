package com.blog.myblog.services;

import com.blog.myblog.domain.alerts.Alert;
import com.blog.myblog.repositories.AlertRepository;
import com.blog.myblog.security.AuthenticationContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository alertRepository;
    private final AuthenticationContext authenticationContext;




    public List<Alert> getAlertsForLoggedInUser(){
        var loggedInUser = authenticationContext.getSignedInAdri();
        return  alertRepository.findAllByTargetUser(loggedInUser.getId());
    }

    public void deleteExpiredAlerts(LocalDateTime expirationTime) {
        alertRepository.deleteByExpirationTime(expirationTime);
    }
}
