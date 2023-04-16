package com.market.sweetpotato.api.repository;

import com.market.sweetpotato.api.domain.entity.Authority;

import java.util.List;

public interface MemberRepositoryCustom {
    void addAuthorities(List<Authority> authorities);
}
