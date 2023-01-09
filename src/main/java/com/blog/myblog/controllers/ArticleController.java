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

    @GetMapping("/specific_article")
    public ResponseEntity<ArticleDetailsDTO> getSpecificArticle(@PathVariable Long id) {
        ArticleDetailsDTO article = articleService.getSpecificArticle(id);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PutMapping ("/specific_article")
    public ResponseEntity<Void> editArticle(@PathVariable Long id, @RequestBody ArticleEditDTO editDTO) {
        articleService.editArticle(id,editDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
