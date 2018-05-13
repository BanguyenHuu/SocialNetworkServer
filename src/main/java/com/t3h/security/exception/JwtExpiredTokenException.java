package com.t3h.security.exception;

import javax.security.sasl.AuthenticationException;


public class JwtExpiredTokenException extends AuthenticationException {
    private String token;
    public JwtExpiredTokenException(String msg, String token, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
