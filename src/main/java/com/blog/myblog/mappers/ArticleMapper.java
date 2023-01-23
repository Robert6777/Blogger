package com.blog.myblog.mappers;

import com.blog.myblog.domain.AppUser;
import com.blog.myblog.domain.Article;
import com.blog.myblog.dto.appUser.UserListDTO;
import com.blog.myblog.dto.article.ArticleCreateDTO;
import com.blog.myblog.dto.article.ArticleDetailsDTO;
import com.blog.myblog.dto.article.ArticleEditDTO;
import com.blog.myblog.dto.article.ArticleListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = SpringMapperConfig.class)
public interface ArticleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "articleCode", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "alerts", ignore = true)
    Article createNewArticle(ArticleCreateDTO dto);



    List<ArticleListDTO> mapToArticleListDTOList(List<Article> articles);

    ArticleListDTO mapToArticleListDTO(Article article);

    ArticleDetailsDTO mapToArticleDetailsDTO(Article article);

    @Mapping(target = "name", expression = "java(appUser.getLastName() + \",\" + appUser.getFirstName())")
    UserListDTO mapToAuthorDTO(AppUser appUser);



    @Mapping(target = "id", ignore = true)
    @Mapping(target = "articleCode", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "alerts", ignore = true)
    void updateArticle (@MappingTarget Article article, ArticleEditDTO dto);
}
