package com.blog.myblog.services;

import com.blog.myblog.dto.ArticleDetailsDTO;
import com.blog.myblog.dto.ArticleListDTO;
import com.blog.myblog.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
    
    private ArticleRepository articleRepository;


    public Long createArticle() {
        return null;
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
