package com.blog.myblog.domain.alerts;

import com.blog.myblog.domain.Article;
import com.blog.myblog.enums.AlertEnums;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(AlertEnums.Types.ARTICLE_RATED)
@Getter
@Setter
public class ArticleRatedAlert extends Alert {

    @ManyToOne
    @JoinColumn(name = "article")
    private Article article;

}
