package com.blog.myblog.dto.comment;

import com.blog.myblog.dto.appUser.UserListDTO;
import com.blog.myblog.dto.article.ArticleListDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDetailsDTO {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String body;
    private UserListDTO author;
    private ArticleListDTO article;
    private Short version;
}
