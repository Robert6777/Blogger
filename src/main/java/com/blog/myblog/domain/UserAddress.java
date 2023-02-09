package com.blog.myblog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class UserAddress implements ConcurrencySafeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "street_number", nullable = false)
    private String streetNumber;

    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "version", nullable = false)
    @Version
    private int version;


    @Override
    public Integer version() {
        return null;
    }
}
