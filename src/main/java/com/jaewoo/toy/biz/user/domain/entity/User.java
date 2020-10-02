package com.jaewoo.toy.biz.user.domain.entity;


import com.jaewoo.toy.common.jpa.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String loginId;

    private String password;

    private String name;

    private String firstName;

    private String lastName;

    private String emailAddress;

    @Embedded
    private Address address;
}
