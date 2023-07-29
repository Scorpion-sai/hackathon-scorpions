/*
package com.scorpions.escs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.stereotype.Component;

@Profile("psdev")
@Configuration
@Component("disableSecurityConfigurationBean")
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class DisableSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .requestMatchers("/**");
    }

    //OR - Use any one of these two methods

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .requestMatchers("/")
                .permitAll();
    }
}*/
