package com.haejun.study.config

import com.haejun.study.business.MemberService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.reactor.mono
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class AuthenticationManager(
    private val memberService: MemberService,
) : ReactiveAuthenticationManager {

    override fun authenticate(authentication: Authentication): Mono<Authentication> {
        return mono(Dispatchers.Unconfined) {
            val member = memberService.findByEmail(authentication.principal as String)
                ?: throw BadCredentialsException("존재하지 않는 회원입니다.")

            UsernamePasswordAuthenticationToken(
                member.email,
                member.password,
                listOf(SimpleGrantedAuthority(member.role.toString()))
            )
        }
    }
}
