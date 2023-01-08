package com.blog.myblog.security;

import com.blog.myblog.domain.AppUser;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationContext {

    // this is dummy data for now
    public AppUser getSignedInUser(){

        return new AppUser();
    }


}
