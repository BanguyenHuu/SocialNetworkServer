package com.t3h.security.register;

import com.t3h.manager.BaseManager;
import com.t3h.mysql.tables.User;
import com.t3h.mysql.tables.records.UserRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by ducnd on 6/25/17.
 */
@Component
public class AjaxRegisterProvider implements AuthenticationProvider {

    @Autowired
    private BaseManager baseManager;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AjaxAuthenRegister register = (AjaxAuthenRegister) authentication;
        UserRecord userRecord = baseManager.getDslContext()
                .selectFrom(User.USER)
                .where(User.USER.USERNAME
                        .eq(register.getPrincipal()
                                .getUsername())).fetchOne();
        return new UsernamePasswordAuthenticationToken(
                authentication.getPrincipal(),
                authentication.getCredentials(),
                new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(AjaxAuthenRegister.class);
    }
}
