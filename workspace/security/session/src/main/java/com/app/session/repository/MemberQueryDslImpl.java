package com.app.session.repository;

import com.app.session.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class MemberQueryDslImpl implements MemberQueryDsl{
    private final JPAQueryFactory query;

//    @Override
//    public Optional<Member> login(String memberId, String MemberPassword) {
//        return query.select(member)
//
//
//    }
}
