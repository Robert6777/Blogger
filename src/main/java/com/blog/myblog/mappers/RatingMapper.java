package com.blog.myblog.mappers;

import com.blog.myblog.domain.Rating;
import com.blog.myblog.dto.rating.RatingCreateDTO;
import com.blog.myblog.dto.rating.RatingListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = SpringMapperConfig.class, uses = ExistingEntityResolver.class)
public interface RatingMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "reviewer", ignore = true)
    @Mapping(target = "article", source = "articleId", qualifiedByName = "ExistingEntityResolver#findArticleById")
    Rating createRating(RatingCreateDTO dto);

    List<RatingListDTO> mapToRatingListDTOList(List<Rating> ratings);

    RatingListDTO mapToRatingListDTO(Rating rating);

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "commenter", ignore= true)
//    @Mapping(target = "article", source = "articleId", qualifiedByName = "ExistingEntityResolver#findArticleById")
//    @Mapping(target = "version", ignore= true)
//    Comment createComment(CommentCreateDTO dto);
//
//
//    List<CommentListDTO> mapToCommentListDTOList(List<Comment> comments);
//
//    CommentListDTO mapToCommentListDTO (Comment comment);
//
//    @Mapping(target = "name", expression = "java(appUser.getLastName() + \",\" + appUser.getFirstName())")
//    UserListDTO mapToAuthorDTO(AppUser appUser);
//
//
//    CommentDetailsDTO mapToCommentDetailsDTO(Comment comment);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "commenter", ignore= true)
//    @Mapping(target = "article", ignore= true)
//    @Mapping(target = "version", ignore= true)
//    void updateComment(@MappingTarget Comment comment, CommentEditDTO commentEditDTO);
}
