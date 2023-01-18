package com.blog.myblog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ratings")
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private AppUser author;

    @ManyToOne
    private Article article;

    private Date created_at;

    private Date updated_at;

    private String body;




}
