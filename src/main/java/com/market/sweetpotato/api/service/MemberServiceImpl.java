package com.market.sweetpotato.api.service;

import com.market.sweetpotato.api.domain.entity.Authority;
import com.market.sweetpotato.api.domain.entity.Member;
import com.market.sweetpotato.api.domain.entity.Role;
import com.market.sweetpotato.api.dto.request.LoginReqDto;
import com.market.sweetpotato.api.dto.request.MemberReqDto;
import com.market.sweetpotato.api.dto.response.auth.JwtTokenRespDto;
import com.market.sweetpotato.api.repository.AuthorityRepository;
import com.market.sweetpotato.api.repository.MemberRepository;
import com.market.sweetpotato.api.repository.RoleRepository;
import com.market.sweetpotato.exception.CustomException;
import com.market.sweetpotato.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    private final AuthenticationManagerBuilder authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

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
    public void duplicatedUsername(MemberReqDto memberReqDto) {
        Member memberEntity = memberRepository.findByUsername(memberReqDto.getUsername());

        if(memberEntity != null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("username", "이미 사용중인 사용자 이름입니다.");

            throw new CustomException("이미 사용중인 사용자 이름입니다.");
        }
    }

    @Override
    public JwtTokenRespDto login(LoginReqDto loginReqDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginReqDto.getUsername(), loginReqDto.getPassword());

        Authentication authentication = authenticationManager.getObject().authenticate(authenticationToken);

        return jwtTokenProvider.createToken(authentication);
    }
}
