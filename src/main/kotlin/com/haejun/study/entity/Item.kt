package com.haejun.study.entity

import com.haejun.study.entity.constant.ItemSellStatus
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("item")
class Item(
    @Id
    @Column("id")
    var id: Long? = null,

    @Column("item_nm")
    var itemNm: String,

    @Column("price")
    var price: Int,

    @Column("stock_number")
    var stockNumber: Int,

    @Column("item_detail")
    var itemDetail: String,

    @Column("item_sell_status")
    var itemSellStatus: ItemSellStatus,

    @Column("reg_time")
    var regTime: LocalDateTime,

    @Column("update_time")
    var updateTime: LocalDateTime,
)
