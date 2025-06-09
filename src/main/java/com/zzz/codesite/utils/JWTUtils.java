package com.zzz.codesite.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Map;

public class JWTUtils {
    private static final SecretKey key=Jwts.SIG.HS256.key().build();

    public static String generateJWT(Map<String,Object> claims){
        return Jwts.builder()
                .claims(claims)
                .signWith(key)
                .compact();
    }

    public static Claims parseJWT(String jwt){
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }
}
