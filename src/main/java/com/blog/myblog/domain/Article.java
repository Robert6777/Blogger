package com.blog.myblog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "articles")
@Getter
@Setter
public class Article implements ConcurrencySafeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "article_code", nullable = false)
    private String articleCode;

    @ManyToOne
    @JoinColumn(name = "author")
    private AppUser author;
    
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "version")
    @Version
    private Short version;

    @OneToMany (mappedBy = "article")
    private List<Comment> comments;

    @Override
    public Short version() {
        return this.version;
    }






}
