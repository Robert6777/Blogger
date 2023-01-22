package com.blog.myblog.dto.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateDTO {

    private String body;
    private Long articleId;

}
