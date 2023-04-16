package com.market.sweetpotato.api.service;

import com.market.sweetpotato.api.dto.request.LoginReqDto;
import com.market.sweetpotato.api.dto.request.MemberReqDto;

public interface MemberService {
    void register(MemberReqDto memberReqDto);

    Object login(LoginReqDto loginReqDto);
}
