package com.blog.myblog.mappers;

import com.blog.myblog.domain.Article;
import com.blog.myblog.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistingEntityResolver {

    private final ArticleService articleService;

    @Named("ExistingEntityResolver#findArticleById")
    Article findArticleById(Long articleId){
        return articleId == null ? null : articleService.getArticleEntityById(articleId);
    }

}
