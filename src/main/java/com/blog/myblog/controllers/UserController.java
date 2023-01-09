package com.blog.myblog.controllers;

import com.blog.myblog.dto.appUser.UserCreateDTO;
import com.blog.myblog.dto.appUser.UserDetailsDTO;
import com.blog.myblog.dto.appUser.UserEditDTO;
import com.blog.myblog.dto.appUser.UserListDTO;
import com.blog.myblog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody UserCreateDTO dto) {
        Long id = userService.createUser(dto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserListDTO>> getAllUsers() {
        List<UserListDTO> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailsDTO> getSpecificUser(@PathVariable Long userId) {
        UserDetailsDTO appUser = userService.getSpecificUser(userId);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PutMapping ("/{userId}")
    public ResponseEntity<Void> editUser(@PathVariable Long userId, @RequestBody UserEditDTO editDTO) {
        userService.editUser(userId,editDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
