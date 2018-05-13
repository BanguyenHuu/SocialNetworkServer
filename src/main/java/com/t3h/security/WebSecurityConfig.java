package com.t3h.security;

import com.t3h.Constants;
import com.t3h.security.login.AjaxAuthenLoginProvider;
import com.t3h.security.match.MatchLoginRegister;
import com.t3h.security.match.SkipPathRequestMatcher;
import com.t3h.security.register.AjaxRegisterProvider;
import com.t3h.security.withoutloginregister.AjaxTokenAuthenticationFailureHandler;
import com.t3h.security.withoutloginregister.JwtAuthenticationProvider;
import com.t3h.security.withoutloginregister.JwtTokenAuthenticationProcessingFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducnd on 6/25/17.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private AjaxAuthenticationLoginRegisterSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AjaxAuthenLoginProvider ajaxLoginProcessingFilter;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    private AjaxRegisterProvider registerAuthenticationProvider;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(ajaxLoginProcessingFilter);
        auth.authenticationProvider(jwtAuthenticationProvider);
        auth.authenticationProvider(registerAuthenticationProvider);
    }

    public AjaxLoginRegisterProcessingFilter getFilter() {
        List<String> matchs = new ArrayList<>();
        matchs.add(Constants.ENPOINT_LOGIN);
        matchs.add(Constants.ENPOINT_REGISTER);
        MatchLoginRegister matchLoginRegister = new MatchLoginRegister(matchs);
        AjaxLoginRegisterProcessingFilter filter =
                new AjaxLoginRegisterProcessingFilter(matchLoginRegister, authenticationSuccessHandler, new AjaxAuthenticationLoginRegisterFailureHandler(objectMapper), objectMapper);
        try {
            filter.setAuthenticationManager(authenticationManagerBean());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filter;
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter() {
        List<String> listNotmap = new ArrayList<>();
        listNotmap.add(Constants.ENPOINT_LOGIN);
        listNotmap.add(Constants.ENPOINT_REGISTER);
        RequestMatcher matcher = new SkipPathRequestMatcher(listNotmap, Constants.ENPOINT_MATCH_API);
        JwtTokenAuthenticationProcessingFilter filter
                = new JwtTokenAuthenticationProcessingFilter(matcher, new AjaxTokenAuthenticationFailureHandler(objectMapper), objectMapper);
        try {
            filter.setAuthenticationManager(authenticationManagerBean());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers(Constants.ENPOINT_LOGIN, Constants.ENPOINT_LOGIN).permitAll() // Login end-point
                .and().authorizeRequests()
                .antMatchers(Constants.ENPOINT_MATCH_API).authenticated()
                .and()
                .addFilterBefore(getFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

}
