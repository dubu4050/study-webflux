package com.haejun.study.business

import com.haejun.study.dto.MemberFormDto
import com.haejun.study.entity.Member
import com.haejun.study.entity.constant.Role
import com.haejun.study.repository.MemberRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
) {

    suspend fun findByEmail(email: String): Member? {
        return memberRepository.findByEmail(email)
    }

    suspend fun create(dto: MemberFormDto): Member {
        findByEmail(dto.email)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }

        return memberRepository.save(
            with(dto) {
                Member(
                    name = name,
                    email = email,
                    password = passwordEncoder.encode(password),
                    address = address,
                    role = Role.USER,
                )
            }
        )
    }
}
