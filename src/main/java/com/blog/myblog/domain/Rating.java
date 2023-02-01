package com.blog.myblog.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
@Getter
@Setter
public class Rating {

    private static final int MAX_RATING = 10;
    private static final int MIN_RATING = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "rating")
    @Max(MAX_RATING)
    @Min(MIN_RATING)
    private Integer rating;

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JoinColumn(name = "reviewer")
    private AppUser reviewer;

    @ManyToOne
    @JoinColumn(name = "article")
    private Article article;



}
