package com.lop.smartcitykhouribga.security;

import java.util.Date;

import com.lop.smartcitykhouribga.models.Entities.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JwtTokenUtil {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    /**
     * Generate a JWT token for the user
     *
     * @param user the user to generate the token for
     * @return the generated token
     */
    public String generateAccessToken(User user) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s,%s", user.getId(), user.getMail(), user.getRole()))
                .setIssuer("CodeJava")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

    }

    /**
     * Validate the JWT token
     * @param token the token to validate
     * @return true if the token is valid, false otherwise
     */
    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error(String.format("Token %s expired", token), ex.getMessage());
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Signature validation failed");
        }
        return false;
    }

    /**
     * Get the user subject which contains the user id and the user mail separated by a comma
     * @param token the token to get the user id from
     * @return the user id
     */
    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }


    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}