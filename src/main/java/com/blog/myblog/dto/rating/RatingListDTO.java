package com.blog.myblog.dto.rating;


import com.blog.myblog.dto.article.ArticleListDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingListDTO {

    private Long id;
    private Integer rating;
    private String body;
    private ArticleListDTO article;
}
