package com.blog.myblog.services;

import com.blog.myblog.domain.AppUser;
import com.blog.myblog.dto.appUser.UserCreateDTO;
import com.blog.myblog.dto.appUser.UserDetailsDTO;
import com.blog.myblog.dto.appUser.UserEditDTO;
import com.blog.myblog.dto.appUser.UserListDTO;
import com.blog.myblog.mappers.UserMapper;
import com.blog.myblog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Long createUser(UserCreateDTO dto) {
        AppUser appUser = userMapper.createNewUser(dto);
        return userRepository.save(appUser).getId();
    }

    public List<UserListDTO> getAllUsers() {
        List<AppUser> users = userRepository.findAll();
        return userMapper.mapToUserListDTOList(users);
    }

    public UserDetailsDTO getSpecificUser(Long id) {
        AppUser appUser = getSpecificArticleById(id);
        return userMapper.mapToUserDetailsDTO(appUser);
    }

    public void editUser(Long id, UserEditDTO editDTO) {
        AppUser appUser = getSpecificArticleById(id);
        userMapper.updateUser(appUser,editDTO);

    }

    public void deleteUser(Long id) {
        AppUser appUser = getSpecificArticleById(id);
        userRepository.delete(appUser);
    }

    private AppUser getSpecificArticleById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found with id " + id));
    }
}
