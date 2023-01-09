package com.blog.myblog.dto.appUser;

import com.blog.myblog.dto.address.AddressDetailsDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDetailsDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String status;
    private List<AddressDetailsDTO> addressList;
    private Short version;


}
