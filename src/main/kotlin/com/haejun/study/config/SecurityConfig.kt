package com.haejun.study.config

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationFailureHandler
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler
import org.springframework.security.web.server.authorization.HttpStatusServerAccessDeniedHandler
import java.net.URI

@EnableWebFluxSecurity
class SecurityConfig(
    private val authenticationManager: AuthenticationManager,
) {
    @Bean
    fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
            .csrf()
            .disable()
            .formLogin()
            .loginPage("/members/login")
            .authenticationSuccessHandler(RedirectServerAuthenticationSuccessHandler("/"))
            .authenticationFailureHandler(RedirectServerAuthenticationFailureHandler("/members/login/error"))
            .and()
            .logout()
            .logoutUrl("/members/logout")
            .logoutSuccessHandler(RedirectServerLogoutSuccessHandler().apply { setLogoutSuccessUrl(URI("/")) })
            .and()
            .authorizeExchange {
                it.pathMatchers("/", "/members/**", "/item/**", "/images/**").permitAll()
                    .pathMatchers("/admin/**").hasRole("ADMIN")
                    .anyExchange().authenticated()
            }
            .authenticationManager(authenticationManager)
            .exceptionHandling()
            .accessDeniedHandler(HttpStatusServerAccessDeniedHandler(HttpStatus.UNAUTHORIZED))
            .and()
            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }
}
