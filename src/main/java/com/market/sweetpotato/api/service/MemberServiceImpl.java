package com.market.sweetpotato.api.service;

import com.market.sweetpotato.api.domain.entity.Authority;
import com.market.sweetpotato.api.domain.entity.Member;
import com.market.sweetpotato.api.domain.entity.Role;
import com.market.sweetpotato.api.dto.request.LoginReqDto;
import com.market.sweetpotato.api.dto.request.MemberReqDto;
import com.market.sweetpotato.api.repository.AuthorityRepository;
import com.market.sweetpotato.api.repository.MemberRepository;
import com.market.sweetpotato.api.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public void register(MemberReqDto memberReqDto) {

        Member memberEntity = memberReqDto.toEntity();
        memberEntity = memberRepository.save(memberEntity);

        Role roleMember = roleRepository.findByRoleName("ROLE_USER");

        Authority authority = Authority.builder()
                .memberId(memberEntity.getId())
                .roleId((long) roleMember.getId())
                .build();

        authorityRepository.save(authority);
    }

    @Override
    public Object login(LoginReqDto loginReqDto) {



        return null;
    }
}
