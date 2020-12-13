package com.jaewoo.toy.biz.member.repository;

import com.jaewoo.toy.biz.member.domain.Member;
import com.jaewoo.toy.biz.member.repository.support.MemberRepositorySupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    MemberRepositorySupport memberRepositorySupport;

    @Test
    public void queryDslTest() {
        List<Member> members = memberRepositorySupport.findByMember2("정");

        System.out.println(members);
    }

}