package com.example.book_shop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {
    private final String[] whiteList = new String[]
            {
                    "/",
                    "/auth/register",
                    "/auth/sign-in",
                    "/css/**",
                    "/css"};

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers(whiteList)
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(
                        loginConfig -> loginConfig
                                .loginPage("/auth/sign-in")
                                .loginProcessingUrl("/auth/sign-in/post")
//                                .loginProcessingUrl("/auth/sign-in")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/", true)
                ).logout(
                        logoutConfig -> logoutConfig
                                .logoutSuccessUrl("/auth/login")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                )
                .rememberMe(
                        rememberMeConfig -> rememberMeConfig
                                .rememberMeParameter("rem")
                                .tokenValiditySeconds(24 * 60 * 60)
                )
                .build();
    }
}
