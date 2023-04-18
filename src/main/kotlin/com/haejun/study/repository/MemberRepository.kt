package com.haejun.study.repository

import com.haejun.study.entity.Member
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface MemberRepository : CoroutineCrudRepository<Member, Long> {
    suspend fun findByEmail(email: String): Member?
}
