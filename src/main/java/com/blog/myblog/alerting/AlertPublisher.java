package com.blog.myblog.alerting;

import com.blog.myblog.domain.AppUser;
import com.blog.myblog.domain.Article;
import com.blog.myblog.domain.alerts.ArticleCommentedAlert;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlertPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public void publishArticleComment(AppUser user, Article article) {
        var alert = new ArticleCommentedAlert();
        alert.setArticle(article);
        alert.setUser(user);
        eventPublisher.publishEvent(alert);
    }
}
