package com.market.sweetpotato.security.jwt;

import com.market.sweetpotato.api.dto.response.auth.JwtTokenRespDto;
import com.market.sweetpotato.security.PrincipalsUserDetails;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {

    private final Key key;


    public JwtTokenProvider(@Value("${jwt.secretKey}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public JwtTokenRespDto createToken(Authentication authentication) {
//        StringBuilder sb =  new StringBuilder();
//
//        authentication.getAuthorities().forEach(grantedAuthority -> {
//            sb.append(grantedAuthority.getAuthority());
//            sb.append(",");
//        });
//
//        sb.delete(sb.length() - 1, sb.length());

        String authorities = authentication.getAuthorities()
                .stream()
                .map(authority -> authority.getAuthority())
                .reduce((a, b) -> a + "," + b)
                .orElse("");

        long now = (new Date()).getTime();
        Date tokenExpiresDate = new Date(now + (1000 * 60 * 30)); // token 만료 시간 30분

        PrincipalsUserDetails userDetails = (PrincipalsUserDetails) authentication.getPrincipal();

        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("userId", userDetails.getUserId())
                .claim("auth", authorities)
                .setExpiration(tokenExpiresDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return JwtTokenRespDto.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .build();
    }
    public boolean validateToken(String token) {
        try {
            // 토큰이 유효한지 확인 문제가 생기면 exception 발생

            Jwts.parserBuilder()
                    .setSigningKey(key) // 해당 키로 이루어져 있는지 확인 작업
                    .build()
                    .parseClaimsJws(token);
            return true;

        } catch (SecurityException | MalformedJwtException e) {
            // 토큰이 변조되었을 경우, security 라이브러리에 오류가 있을 떄.
            log.error("Invalid JWT signature.", e);
            return false;

        } catch (ExpiredJwtException e)  {
            // 토큰이 만료되었을 경우
            log.error("Expired JWT token.", e);
            return false;

        } catch (UnsupportedJwtException e) {
            // 토큰이 지원되지 않는 형식일 경우
            log.error("Unsupported JWT token.", e);
            return false;

        } catch (IllegalArgumentException e) {
            // 토큰이 비어있을 경우
            log.error("JWT claims string is empty.", e);
            return false;

        } catch (Exception e) {
            log.error("Unknown error.", e);
            return false;
        }
    }


    public Authentication getAuthentication(String token) {
        Claims claims = parseClaims(token);
        Object roles = claims.get("authorities");

        if (roles == null) {
            throw new RuntimeException("권한이 없습니다.");
        }

        String[] rolesArray = roles.toString().split(",");
        List<SimpleGrantedAuthority> authorities = Arrays.stream(rolesArray)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        UserDetails userDetails = User.builder()
                .username(claims.getSubject())
                .password("")
                .authorities(authorities)
                .build();

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
