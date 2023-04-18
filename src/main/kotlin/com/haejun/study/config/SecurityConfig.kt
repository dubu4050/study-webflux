package com.haejun.study.config

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.invoke
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationFailureHandler
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler
import org.springframework.security.web.server.authorization.HttpStatusServerAccessDeniedHandler

@EnableWebFluxSecurity
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http {
            csrf { disable() }
            formLogin {
                loginPage = "/members/login"
                authenticationSuccessHandler = RedirectServerAuthenticationSuccessHandler("/")
                authenticationFailureHandler = RedirectServerAuthenticationFailureHandler("/members/login/error")
            }
            authorizeExchange {
                authorize("/", permitAll)
                authorize("/members/**", permitAll)
                authorize("/item/**", permitAll)
                authorize("/images/**", permitAll)
                authorize("/admin/**", hasRole("ADMIN"))
                authorize(anyExchange, authenticated)
            }
            exceptionHandling {
                accessDeniedHandler = HttpStatusServerAccessDeniedHandler(HttpStatus.UNAUTHORIZED)
            }
        }
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }
}
