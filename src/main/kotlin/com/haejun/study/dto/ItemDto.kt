package com.haejun.study.dto

import java.time.LocalDateTime

data class ItemDto(
    val id: Long = 0L,
    val itemNm: String = "",
    val price: Int = 0,
    val itemDetail: String = "",
    val sellStatCd: String = "",
    val regTime: LocalDateTime = LocalDateTime.now(),
    val updateTime: LocalDateTime = LocalDateTime.now(),
)
