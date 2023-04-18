package com.haejun.study.config

import com.haejun.study.repository.MemberRepository
import kotlinx.coroutines.reactor.mono
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class StudyUserDetailsService(
    private val memberRepository: MemberRepository,
) : ReactiveUserDetailsService {
    override fun findByUsername(username: String?): Mono<UserDetails> {
        return mono {
            val member = memberRepository.findByEmail(username ?: "")
                ?: throw BadCredentialsException("존재하지 않는 사용자입니다.")

            User(
                member.email,
                member.password,
                listOf(SimpleGrantedAuthority(member.role.toString()))
            )
        }
    }
}
