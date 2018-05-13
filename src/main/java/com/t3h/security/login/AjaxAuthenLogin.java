package com.t3h.security.login;

import com.t3h.Constants;
import com.t3h.security.UserContext;

import com.t3h.security.Utils;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class AjaxAuthenLogin extends AbstractAuthenticationToken {
    private UserContext userContext;
    private String password;

    public AjaxAuthenLogin(String username, String password) {
        super(null);
        this.password = password;
        String token = Utils.getToken(username, Constants.KEY_TOKEN);
        userContext = new UserContext(username, token);
    }

    @Override
    public UserContext getPrincipal() {
        return userContext;
    }

    @Override
    public String getCredentials() {
        return password;
    }
}
