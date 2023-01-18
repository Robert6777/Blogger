package com.blog.myblog.dto.appUser;

import com.blog.myblog.dto.address.AddressDetailsDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDTO {

    private Long id;
    private String name;
    private String email;
    private String role;
}
