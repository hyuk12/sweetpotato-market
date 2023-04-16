package com.market.sweetpotato.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginReqDto {
    private String username;
    private String password;
}
