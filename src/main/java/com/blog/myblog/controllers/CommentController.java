package com.blog.myblog.controllers;

import com.blog.myblog.dto.comment.CommentCreateDTO;
import com.blog.myblog.dto.comment.CommentDetailsDTO;
import com.blog.myblog.dto.comment.CommentEditDTO;
import com.blog.myblog.dto.comment.CommentListDTO;
import com.blog.myblog.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ResponseBody
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Long>createComment(@RequestBody CommentCreateDTO dto){
        Long id = commentService.createComment(dto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommentListDTO>>getAllComments(){
        List<CommentListDTO> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDetailsDTO> getSpecificComment(@PathVariable Long commentId) {
        CommentDetailsDTO commentDetailsDTO = commentService.getSpecificComment(commentId);
        return new ResponseEntity<>(commentDetailsDTO, HttpStatus.OK);
    }

    @PutMapping ("/{commentId}")
    public ResponseEntity<Void> editComment(@PathVariable Long commentId, @RequestBody CommentEditDTO editDTO) {
        commentService.editComment(commentId,editDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
