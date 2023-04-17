package com.market.sweetpotato.security;

import com.market.sweetpotato.api.domain.entity.Member;
import com.market.sweetpotato.api.repository.MemberRepository;
import com.market.sweetpotato.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member memberEntity = memberRepository.findByUsername(username);

        System.out.println("memberEntity = " + memberEntity.getUsername() + " " + memberEntity.getPassword());

        if (memberEntity == null) {
            throw new CustomException("존재하지 않는 사용자입니다.");
        }

        return memberEntity.toPrincipal();
    }

}
