package com.blog.myblog.alerting;

import com.blog.myblog.domain.Comment;
import com.blog.myblog.domain.Rating;
import com.blog.myblog.domain.alerts.ArticleCommentedAlert;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlertPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public void publishArticleCommented(Comment comment) {
        var alert = new ArticleCommentedAlert();
        alert.setArticle(comment.getArticle());
        alert.setAlertReceiver(comment.getArticle().getAuthor());
        eventPublisher.publishEvent(alert);
    }

    public void publishArticleRated(Rating rating) {
        var alert = new ArticleCommentedAlert();
        alert.setArticle(rating.getArticle());
        alert.setAlertReceiver(rating.getArticle().getAuthor());
        eventPublisher.publishEvent(alert);
    }
}
