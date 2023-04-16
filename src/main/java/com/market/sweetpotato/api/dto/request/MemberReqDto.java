package com.market.sweetpotato.api.dto.request;

import com.market.sweetpotato.api.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter @Setter
@ToString
public class MemberReqDto {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int roleId;

    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .name(name)
                .email(email)
                .phone(phone)
                .address(address)
                .build();
    }
}
