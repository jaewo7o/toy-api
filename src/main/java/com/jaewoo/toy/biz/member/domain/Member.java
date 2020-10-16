package com.jaewoo.toy.biz.member.domain;

import com.jaewoo.toy.biz.user.domain.entity.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    //@OneToMany(mappedBy = "member")
    //private List<Order> orders = new ArrayList<Order>();
}
