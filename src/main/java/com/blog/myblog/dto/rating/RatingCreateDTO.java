package com.blog.myblog.dto.rating;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingCreateDTO {

    private Integer rating;
    private String body;
    private Long articleId;
}
