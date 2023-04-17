package com.market.sweetpotato.api.service;

import com.market.sweetpotato.api.dto.request.LoginReqDto;
import com.market.sweetpotato.api.dto.request.MemberReqDto;
import com.market.sweetpotato.api.dto.response.auth.JwtTokenRespDto;

public interface MemberService {
    void register(MemberReqDto memberReqDto);
    void duplicatedUsername(MemberReqDto memberReqDto);
    JwtTokenRespDto login(LoginReqDto loginReqDto);
}
