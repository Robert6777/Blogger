package com.blog.myblog.dto.article;

import com.blog.myblog.dto.appUser.UserListDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ArticleDetailsDTO {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String articleCode;
    private String title;
    private String body;
    private UserListDTO author;
    private Short version;

}
