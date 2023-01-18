package com.blog.myblog.repositories;

import com.blog.myblog.domain.AppUser;
import com.blog.myblog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

@Query("select max(articleCode) from Article where author = :author")
    Optional<String> getMaxArticleCode(@Param ("author") AppUser appUser);
}
