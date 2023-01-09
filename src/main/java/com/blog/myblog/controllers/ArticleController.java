package com.blog.myblog.controllers;

import com.blog.myblog.dto.article.*;
import com.blog.myblog.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<Long> createArticle(@RequestBody ArticleCreateDTO dto) {
        Long id = articleService.createArticle(dto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ArticleListDTO>> getAllArticles() {
        List<ArticleListDTO> articles = articleService.getAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleDetailsDTO> getSpecificArticle(@PathVariable Long articleId) {
        ArticleDetailsDTO article = articleService.getSpecificArticle(articleId);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PutMapping ("/{articleId}")
    public ResponseEntity<Void> editArticle(@PathVariable Long articleId, @RequestBody ArticleEditDTO editDTO) {
        articleService.editArticle(articleId,editDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
