package com.blog.myblog.dto.article;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleListDTO {

    private Long id;
    private String articleCode;
    private String title;
    private String body;
    private Double avgRating;
}
