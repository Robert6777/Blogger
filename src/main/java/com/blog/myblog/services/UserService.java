package com.blog.myblog.services;

import com.blog.myblog.domain.AppUser;
import com.blog.myblog.domain.Article;
import com.blog.myblog.dto.article.ArticleDetailsDTO;
import com.blog.myblog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;



    private AppUser getSpecificArticleById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found with id " + id));
    }


}
