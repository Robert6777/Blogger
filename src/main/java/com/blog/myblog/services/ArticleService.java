package com.blog.myblog.services;

import com.blog.myblog.domain.Article;
import com.blog.myblog.dto.article.ArticleCreateDTO;
import com.blog.myblog.dto.article.ArticleDetailsDTO;
import com.blog.myblog.dto.article.ArticleListDTO;
import com.blog.myblog.mappers.ArticleMapper;
import com.blog.myblog.repositories.ArticleRepository;
import com.blog.myblog.security.AuthenticationContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private ArticleRepository articleRepository;
    private AuthenticationContext authenticationContext;
    private ArticleMapper articleMapper;


    public Long createArticle(ArticleCreateDTO dto) {
        Article article = articleMapper.createNewArticle(dto);
        article.setAuthor(authenticationContext.getSignedInUser());
        return articleRepository.save(article).getId();
    }

    public List<ArticleListDTO> getAllArticles() {
        return null;
    }

    public ArticleDetailsDTO getSpecificArticle(Long id) {
        return null;
    }

    public void deleteArticle(Long id) {
    }

    public void editArticle(Long id) {
    }
}
