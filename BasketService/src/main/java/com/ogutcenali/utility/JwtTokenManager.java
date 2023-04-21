package com.ogutcenali.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ogutcenali.exception.AuthException;
import com.ogutcenali.exception.ErrorType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Date;
import java.util.Optional;

@ControllerAdvice
public class JwtTokenManager {

    @Value("${jwt.secretKey}")
    String password ;
    private final Long extraTime = 1000L * 60 * 90;


    public Optional<String> createToken(Long authid) {
        String token = "";
        token = JWT.create().withAudience()
                .withClaim("id", authid)
                .withIssuer("Mam")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + extraTime))
                .sign(Algorithm.HMAC512(password));
        if (token == null) throw new AuthException(ErrorType.TOKEN_ERROR);
        return Optional.of(token);
    }

    public Optional<Long> decodeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC512(password);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("Mam").build();
        DecodedJWT decodedJWT = verifier.verify(token);
        if (decodedJWT == null) throw new AuthException(ErrorType.TOKEN_DECODE_ERROR);
        return Optional.of(decodedJWT.getClaim("id").asLong());
    }


}
