package com.blog.myblog.dto.article;

import com.blog.myblog.dto.appUser.AuthorDTO;
import com.blog.myblog.dto.appUser.UserDetailsDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDetailsDTO {

    private Long id;
    private String articleCode;
    private String title;
    private String body;
    private AuthorDTO author;
    private Short version;



}
