package com.blog.myblog.controllers;

import com.blog.myblog.dto.article.*;
import com.blog.myblog.services.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<Long> createArticle(ArticleCreateDTO dto) {
        Long id = articleService.createArticle(dto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ArticleListDTO>> getAllArticles() {
        List<ArticleListDTO> articles = articleService.getAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/specific_article")
    public ResponseEntity<ArticleDetailsDTO> getSpecificArticle(ArticleIdDTO dto) {
        ArticleDetailsDTO article = articleService.getSpecificArticle(dto.getId());
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PutMapping
    @RequestMapping("/specific_article")
    public ResponseEntity<Void> editArticle(ArticleIdDTO idDTO, ArticleEditDTO editDTO) {
        articleService.editArticle(idDTO.getId(),editDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteArticle(ArticleIdDTO dto) {
        articleService.deleteArticle(dto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
