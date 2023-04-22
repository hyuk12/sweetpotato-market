package com.market.sweetpotato.api.controller;

import com.market.sweetpotato.api.dto.request.LoginReqDto;
import com.market.sweetpotato.api.dto.request.MemberReqDto;
import com.market.sweetpotato.api.dto.response.DataResponseDto;
import com.market.sweetpotato.api.dto.response.ResponseDto;
import com.market.sweetpotato.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/member")
    public ResponseEntity<? extends ResponseDto> register(@RequestBody @Valid MemberReqDto memberReqDto){
        // 회원가입 로직
        memberService.duplicatedUsername(memberReqDto);
        memberService.register(memberReqDto);
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }
    // 로그인
    @PostMapping("/member/login")
    public ResponseEntity<? extends ResponseDto> login(@RequestBody @Valid LoginReqDto loginReqDto){
        // 로그인 로직
        return ResponseEntity.ok().body(DataResponseDto.of(memberService.login(loginReqDto)));
    }

    // 회원정보 수정

    // 회원정보 삭제

    // 회원정보 조회

    // 회원목록 조회


}
