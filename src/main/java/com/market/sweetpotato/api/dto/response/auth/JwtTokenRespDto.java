package com.market.sweetpotato.api.dto.response.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter @Setter
@ToString
public class JwtTokenRespDto {
    private String grantType;
    private String accessToken;
}
