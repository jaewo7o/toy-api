package com.jaewoo.toy.biz.member.repository.support;

import com.jaewoo.toy.biz.member.domain.Member;
import com.jaewoo.toy.biz.member.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public List<Member> findByMember2(String name) {
        QMember member = QMember.member;
        return queryFactory.selectFrom(member)
                            .where(member.name.contains("정"))
                            .fetch();
    }
}
