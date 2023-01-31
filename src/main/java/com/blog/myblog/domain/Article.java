package com.blog.myblog.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
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

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

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

    @OneToMany (mappedBy = "reviewer")
    private List<Rating> ratings;

    @OneToMany (mappedBy = "article")
    private List<Comment> alerts;

    @Override
    public Short version() {
        return this.version;
    }

    public Double getAvgRating(){
        return ratings.stream().mapToInt(Rating::getRating).average().orElse(0.0);
    }

}
