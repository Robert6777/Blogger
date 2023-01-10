package com.blog.myblog.security;

import com.blog.myblog.domain.AppUser;
import com.blog.myblog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;

@Component
@RequiredArgsConstructor
public class AuthenticationContext {

    private final UserRepository userRepository;

    // hardcoded data until security not implemented
    public AppUser getSignedInUser(){
        return userRepository
                .findById(0L)
                .orElseThrow(()-> new EntityNotFoundException("Not found"));
    }


}
