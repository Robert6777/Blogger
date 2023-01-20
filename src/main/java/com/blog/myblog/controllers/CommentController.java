package com.blog.myblog.controllers;

import com.blog.myblog.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@ResponseBody
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

//    @PostMapping
//    public ResponseEntity<Long> createComment(@RequestBody CommentCreateDTO dto) {
//        Long id = commentService.createComment(dto);
//        return new ResponseEntity<>(id, HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<CommentListDTO>> getAllArticles() {
//        List<CommentListDTO> comments = commentService.getAllComments();
//        return new ResponseEntity<>(comments, HttpStatus.OK);
//    }

//    @GetMapping("/{commentId}")
//    public ResponseEntity<CommentDetailsDTO> getSpecificArticle(@PathVariable Long commentId) {
//        ArticleDetailsDTO article = articleService.getSpecificArticle(articleId);
//        return new ResponseEntity<>(article, HttpStatus.OK);
//    }
//
//    @PutMapping ("/{commentId}")
//    public ResponseEntity<Void> editArticle(@PathVariable Long commentId, @RequestBody ArticleEditDTO editDTO) {
//        articleService.editArticle(articleId,editDTO);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{commentId}")
//    public ResponseEntity<Void> deleteArticle(@PathVariable Long commentId) {
//        articleService.deleteArticle(articleId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
