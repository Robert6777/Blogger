package com.blog.myblog.dto.appUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListDTO {

    private Long id;
    private String name;
    private String email;
    private String role;
}
