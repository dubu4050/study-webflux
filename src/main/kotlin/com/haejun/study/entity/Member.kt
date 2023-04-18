package com.haejun.study.entity

import com.haejun.study.entity.constant.Role
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "member")
class Member(
    @Id
    @Column("id")
    var id: Long? = null,

    @Column("name")
    var name: String,

    @Column("email")
    var email: String,

    @Column("password")
    var password: String,

    @Column("address")
    var address: String,

    @Column("role")
    var role: Role,
)
