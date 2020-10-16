package com.jaewoo.toy.biz.member.service;

import com.jaewoo.toy.biz.member.domain.Member;
import com.jaewoo.toy.biz.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long saveId = memberService.join(member);

        // then
        Member saveMember = memberRepository.findById(saveId).get();
        Assertions.assertThat(member).isEqualTo(saveMember);
    }

    @Test
    void findMembers() {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when, then
        Assertions.assertThatThrownBy(() -> {
            memberService.join(member1);
            memberService.join(member2); //예외가 발생해야 한다.
        });
    }
}