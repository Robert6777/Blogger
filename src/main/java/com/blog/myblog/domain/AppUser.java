package com.blog.myblog.domain;


import com.blog.myblog.domain.alerts.Alert;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "app_users")
@Getter
@Setter
public class AppUser implements ConcurrencySafeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    @Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;

    @Column(name = "role", nullable = true)
    private String role;

    @Column(name = "status", nullable = true)
    private String status;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserAddress> addressList;

    @OneToMany (mappedBy = "author")
    private List<Article> articles;

    @OneToMany (mappedBy = "commenter")
    private List<Comment> comments;

    @OneToMany (mappedBy = "reviewer")
    private List<Rating> ratings;

    @OneToMany (mappedBy = "alertReceiver")
    private List<Alert> alerts;

    @Column(name = "version")
    @Version
    private int version;

    @Override
    public Integer version() {
        return this.version;
    }

    public boolean hasRatedThisArticle(Article article){
        return ratings.stream().map(Rating::getArticle).toList().contains(article);
    }
}
