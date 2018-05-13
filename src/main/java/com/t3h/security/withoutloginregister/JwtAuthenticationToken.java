package com.t3h.security.withoutloginregister;

import com.t3h.Constants;
import com.t3h.security.UserContext;
import com.t3h.security.exception.JwtExpiredTokenException;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;


/**
 * Created by ducnd on 6/25/17.
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {
    private UserContext userContext;

    public JwtAuthenticationToken(String token) {
        super(null);
        Jws<Claims> claimsJws = parseClaims(token, Constants.KEY_TOKEN);
        String username = (String) claimsJws.getBody().get("name");
        this.userContext = new UserContext(username, token);
        this.setAuthenticated(false);
    }

    @Override
    public UserContext getCredentials() {
        return userContext;
    }

    private static Jws<Claims> parseClaims(String token, String signingKey) {
        try {
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
            throw new BadCredentialsException("Invalid JWT token: ", ex);
        } catch (ExpiredJwtException expiredEx) {
            try {
                throw new JwtExpiredTokenException(expiredEx.getMessage(), token, expiredEx);
            } catch (JwtExpiredTokenException e) {
                e.printStackTrace();
            }
        }
        return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
