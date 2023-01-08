package com.blog.myblog.repositories;


import com.blog.myblog.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository <AppUser,Long> {
}
