package com.market.sweetpotato.api.repository;

import com.market.sweetpotato.api.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Optional<Member> findByUsername(String username);


}
