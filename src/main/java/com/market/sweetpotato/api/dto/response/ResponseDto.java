package com.market.sweetpotato.api.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class ResponseDto {
    private final boolean success;
    private final int code;
    private final String message;

    public static ResponseDto ofDefault() {
        return new ResponseDto(true, 200, "Successfully");
    }

    public static ResponseDto of(boolean success, int code, String message) {
        return new ResponseDto(success, code, message);
    }
}
