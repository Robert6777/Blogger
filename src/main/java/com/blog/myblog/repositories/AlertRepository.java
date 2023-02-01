package com.blog.myblog.repositories;

import com.blog.myblog.domain.alerts.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {

    @Query("SELECT alert FROM Alert alert WHERE alert.alertReceiver.id = ?1 ORDER BY alert.createdAt DESC")
    List<Alert> findAllByTargetUser(Long id);

    @Modifying
    @Query("DELETE FROM Alert WHERE createdAt < :expirationTime")
    int deleteByExpirationTime(@Param("expirationTime") LocalDateTime expirationTime);
}
