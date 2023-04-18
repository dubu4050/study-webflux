package com.haejun.study.business

import com.haejun.study.entity.Member
import com.haejun.study.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {
    suspend fun save(member: Member): Member {
        validateDuplicateMember(member.email)

        return memberRepository.save(member)
    }

    private suspend fun validateDuplicateMember(email: String) {
        val member = memberRepository.findByEmail(email)
        if (member != null) {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
    }
}
