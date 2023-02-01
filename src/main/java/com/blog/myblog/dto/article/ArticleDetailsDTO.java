package com.blog.myblog.dto.article;

import com.blog.myblog.dto.appUser.UserListDTO;
import com.blog.myblog.dto.rating.RatingListDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ArticleDetailsDTO {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String articleCode;
    private String title;
    private String body;
    private Double avgRating;
    private List<RatingListDTO> ratings;
    private UserListDTO author;
    private Short version;

}
