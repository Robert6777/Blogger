package com.blog.myblog.alerting;

import com.blog.myblog.domain.Comment;
import com.blog.myblog.domain.alerts.ArticleCommentedAlert;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlertPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public void publishArticleComment(Comment comment) {
        var alert = new ArticleCommentedAlert();
        alert.setArticle(comment.getArticle());
        alert.setUser(comment.getArticle().getAuthor());
        eventPublisher.publishEvent(alert);
    }
}
