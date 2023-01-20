package com.blog.myblog.mappers;

import com.blog.myblog.domain.AppUser;
import com.blog.myblog.domain.Article;
import com.blog.myblog.domain.Comment;
import com.blog.myblog.dto.appUser.UserListDTO;
import com.blog.myblog.dto.article.ArticleListDTO;
import com.blog.myblog.dto.comment.CommentCreateDTO;
import com.blog.myblog.dto.comment.CommentDetailsDTO;
import com.blog.myblog.dto.comment.CommentEditDTO;
import com.blog.myblog.dto.comment.CommentListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = SpringMapperConfig.class, uses = ExistingEntityResolver.class)
public interface CommentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "author", ignore= true)
    @Mapping(target = "article", source = "articleId", qualifiedByName = "ExistingEntityResolver#findArticleById")
    @Mapping(target = "version", ignore= true)
    Comment createComment(CommentCreateDTO dto);


    List<CommentListDTO> mapToCommentListDTOList(List<Comment> comments);

    CommentListDTO mapToCommentListDTO (Comment comment);

    @Mapping(target = "name", expression = "java(appUser.getLastName() + \",\" + appUser.getFirstName())")
    UserListDTO mapToAuthorDTO(AppUser appUser);


    CommentDetailsDTO mapToCommentDetailsDTO(Comment comment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "author", ignore= true)
    @Mapping(target = "article", ignore= true)
    @Mapping(target = "version", ignore= true)
    void updateComment(@MappingTarget Comment comment, CommentEditDTO commentEditDTO);
}
