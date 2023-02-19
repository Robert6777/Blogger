package com.blog.myblog.dto.article;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleEditDTO {

    private String title;
    private String body;
    private int version;
}
