package com.blog.myblog.security;

import com.blog.myblog.domain.AppUser;
import com.blog.myblog.repositories.UserRepository;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;

@Component
public class AuthenticationContext {

    UserRepository userRepository;

    // hardcoded data until security not implemented
    public AppUser getSignedInUser(){
        return userRepository
                .findById(1L)
                .orElseThrow(()-> new EntityNotFoundException("Not found"));
    }


}
