package com.blog.myblog.dto.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDetailsDTO {

    private Long id;
    private String street;
    private String streetNumber;
    private String city;
    private String zipCode;
    private String country;
    private String phoneNumber;
    private Short version;
}
