package com.market.sweetpotato.api.repository;

import com.market.sweetpotato.api.domain.entity.Authority;

import com.market.sweetpotato.api.domain.entity.QAuthority;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final AuthorityRepository authorityRepository;

    @Override
    @Transactional
    public void addAuthorities(List<Authority> authorities) {

    }
}
