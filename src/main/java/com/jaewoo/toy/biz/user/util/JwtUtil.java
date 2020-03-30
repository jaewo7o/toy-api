package com.jaewoo.toy.biz.user.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String TEST_SIGN_KEY = "TEST_KEY";
    private final String ISSUER = "JJW";
    private final Date EXPIRED_TIME = new Date(System.currentTimeMillis() + 1000 * 10);

    public String createToken() {
        return JWT.create()
                .withIssuer(ISSUER)
                .withExpiresAt(EXPIRED_TIME)
                .sign(Algorithm.HMAC256(TEST_SIGN_KEY));
    }

    public void verifyToken(String givenToken) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TEST_SIGN_KEY))
                                .withIssuer(ISSUER)
                                .build();

        verifier.verify(givenToken);
    }
}
