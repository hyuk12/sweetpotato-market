package com.market.sweetpotato.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter @Setter
public class ErrorResponseDto extends ResponseDto{

    Map<String, String> errorData ;

    private ErrorResponseDto(HttpStatus status) {
        super(false, status.value(), "Failed");

    }

    private ErrorResponseDto(HttpStatus status, Exception e) {
        super(false, status.value(), e.getMessage());

    }

    public ErrorResponseDto(HttpStatus status, Exception e,  Map<String, String> errorData) {
        super(false, status.value(), e.getMessage());
        this.errorData = errorData;
    }

    public static  ErrorResponseDto of(HttpStatus status) {
        return new ErrorResponseDto(status);
    }

    public static  ErrorResponseDto of(HttpStatus status, Exception e) {
        return new ErrorResponseDto(status, e);
    }

    public static  ErrorResponseDto of(HttpStatus status, Exception e, Map<String, String> errorData) {
        return new ErrorResponseDto(status, e, errorData);
    }

    public static  ErrorResponseDto empty() {
        return new ErrorResponseDto(null);
    }


}
