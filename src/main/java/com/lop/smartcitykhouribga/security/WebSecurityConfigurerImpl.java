package com.lop.smartcitykhouribga.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfigurerImpl {
    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder encoder;

    /* logger */
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(WebSecurityConfigurerImpl.class);


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder);
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("filterChain");
        http.authenticationProvider(authenticationProvider());

        http.authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/offers/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic();
        log.info("http.build()");
        return http.build();
    }

}