package com.blog.myblog.dto.comment;

import com.blog.myblog.dto.appUser.UserListDTO;
import com.blog.myblog.dto.article.ArticleListDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentListDTO {

    private Long id;
    private String body;
    private UserListDTO commenter;
    private ArticleListDTO article;

}
