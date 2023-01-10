package com.blog.myblog.mappers;

import com.blog.myblog.domain.AppUser;
import com.blog.myblog.domain.UserAddress;
import com.blog.myblog.dto.address.AddressDetailsDTO;
import com.blog.myblog.dto.appUser.UserCreateDTO;
import com.blog.myblog.dto.appUser.UserDetailsDTO;
import com.blog.myblog.dto.appUser.UserEditDTO;
import com.blog.myblog.dto.appUser.UserListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = SpringMapperConfig.class)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "addressList", ignore = true)
    @Mapping(target = "articles", ignore = true)
    @Mapping(target = "version", ignore = true)
    AppUser createNewUser(UserCreateDTO dto);

    List<UserListDTO> mapToUserListDTOList(List<AppUser> articles);

    @Mapping(target = "name", expression = "java(appUser.getLastName() + \",\" + appUser.getFirstName())")
    UserListDTO mapToUserListDTO(AppUser appUser);

    UserDetailsDTO mapToUserDetailsDTO(AppUser user);
    AddressDetailsDTO mapToAddressDetailsDTO (UserAddress addressList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "addressList", ignore = true)
    @Mapping(target = "articles", ignore = true)
    @Mapping(target = "version", ignore = true)
    void updateUser (@MappingTarget AppUser appUser, UserEditDTO dto);


}
