package com.blog.myblog.services;

import com.blog.myblog.domain.AppUser;
import com.blog.myblog.domain.Article;
import com.blog.myblog.dto.article.ArticleCreateDTO;
import com.blog.myblog.dto.article.ArticleDetailsDTO;
import com.blog.myblog.dto.article.ArticleEditDTO;
import com.blog.myblog.dto.article.ArticleListDTO;
import com.blog.myblog.mappers.ArticleMapper;
import com.blog.myblog.repositories.ArticleRepository;
import com.blog.myblog.security.AuthenticationContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final AuthenticationContext authenticationContext;
    private final ArticleMapper articleMapper;


    public Long createArticle(ArticleCreateDTO dto) {
        Article article = articleMapper.createNewArticle(dto);

        var author = authenticationContext.getSignedInUser();
        article.setAuthor(author);

        var generatedArticleCode = generateArticleCode(author);
        article.setArticleCode(generatedArticleCode);

        return articleRepository.save(article).getId();
    }

    //TODO CO AK SA DVAJA AUTORI VOLAJU ROVNAKO...VTEDY TREBA GENEROVAT NOVY KOD A POZICIE SUBSTRING NEBUDU SEDIET
    private String generateArticleCode(AppUser author) {
        var prefix = (author.getLastName().substring(0,2) + author.getFirstName().substring(0,2)).toUpperCase();
        var maxArticleCode = articleRepository.getMaxArticleCode(author);
        var format = "%04d";

        // ak sa nam vrati sting reka-0001, tak od 5.indexu meni string na cislo + navysi pocitadlo o 1
        // ak sa nam nic nevrati, tak automaticky pridava suffix 1
        var numberCode = maxArticleCode.map(s -> Integer.parseInt(s.substring(5))+1).orElse(1);

        return prefix + "-" + String.format(format,numberCode);
    }

    public List<ArticleListDTO> getAllArticles() {
        return articleMapper.mapToArticleListDTOList(articleRepository.findAll());
    }

    public ArticleDetailsDTO getSpecificArticle(Long id) {
        Article article = getSpecificArticleById(id);
        return articleMapper.mapToArticleDetailsDTO(article);
    }

    public void deleteArticle(Long id) {
        Article article = getSpecificArticleById(id);
        articleRepository.delete(article);
    }

    public void editArticle(Long id, ArticleEditDTO dto) {
        Article article = getSpecificArticleById(id);
        articleMapper.updateArticle(article,dto);
    }

    private Article getSpecificArticleById(Long id){
        return articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found with id " + id));
    }
}
