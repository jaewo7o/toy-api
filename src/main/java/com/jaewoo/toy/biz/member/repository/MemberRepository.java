package com.jaewoo.toy.biz.member.repository;


import com.jaewoo.toy.biz.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);
}