package com.blog.myblog.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "ratings")
@Getter
@Setter
public class Comment implements ConcurrencySafeEntity {

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

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JoinColumn(name = "author")
    private AppUser author;

    @ManyToOne
    @JoinColumn(name = "article")
    private Article article;

    @Column(name = "version")
    @Version
    private Short version;

    @Override
    public Short version() {
        return this.version;
    }
}
