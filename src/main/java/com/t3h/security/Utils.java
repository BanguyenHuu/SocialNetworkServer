package com.t3h.security;

import com.t3h.Constants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import java.util.Date;
import java.util.UUID;

public class Utils  {
    public static String getToken(String username, String key) {
        Date date = new Date();
        String jws = Jwts.builder()
                .setIssuer("Stormpath")
                .setSubject("msilverman")
                .claim("name", username)
                .claim("scope", "user")
                .setId(UUID.randomUUID().toString())
                // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
//                .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
                .setIssuedAt(date)
                // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
                .setExpiration(new Date(date.getTime() + Constants.TIME_TOKEN_EXPIRE))
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode(key)
                )
                .compact();
        return jws;
    }
}
