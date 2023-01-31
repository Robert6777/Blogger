package com.blog.myblog.services;


import com.blog.myblog.alerting.AlertPublisher;
import com.blog.myblog.domain.Comment;
import com.blog.myblog.dto.comment.CommentCreateDTO;
import com.blog.myblog.dto.comment.CommentDetailsDTO;
import com.blog.myblog.dto.comment.CommentEditDTO;
import com.blog.myblog.dto.comment.CommentListDTO;
import com.blog.myblog.mappers.CommentMapper;
import com.blog.myblog.repositories.CommentRepository;
import com.blog.myblog.security.AuthenticationContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final AuthenticationContext authenticationContext;
    private final CommentMapper commentMapper;
    private final AlertPublisher publisher;

    public Long createComment(CommentCreateDTO dto) {
        Comment comment = commentMapper.createComment(dto);

        var commenter = authenticationContext.getSignedInAdri();
        comment.setCommenter(commenter);
        publisher.publishArticleComment(comment);

        return commentRepository.save(comment).getId();
    }

    public List<CommentListDTO> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return commentMapper.mapToCommentListDTOList(comments);
    }

    public CommentDetailsDTO getSpecificComment(Long id) {
        Comment comment = getCommentEntityById(id);
        return commentMapper.mapToCommentDetailsDTO(comment);

    }

    public void editComment(Long id, CommentEditDTO commentEditDTO) {
        Comment comment = getCommentEntityById(id);
        comment.detectConcurrentModification(commentEditDTO.getVersion());
        commentMapper.updateComment(comment, commentEditDTO);
    }

    public void deleteComment(Long id) {
        Comment comment = getCommentEntityById(id);
        commentRepository.delete(comment);
    }

    public Comment getCommentEntityById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found with id " + id));
    }
}
