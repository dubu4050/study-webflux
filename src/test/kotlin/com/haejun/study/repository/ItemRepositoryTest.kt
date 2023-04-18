package com.haejun.study.repository

import com.haejun.study.entity.Item
import com.haejun.study.entity.constant.ItemSellStatus
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    private lateinit var itemRepository: ItemRepository

    @Test
    @DisplayName("상품 저장 테스트")
    fun createItemTest() = runBlocking {
        val item = itemRepository.save(
            Item(
                itemNm = "테스트 상품",
                price = 10_000,
                itemDetail = "테스트 상품 상세 설명",
                itemSellStatus = ItemSellStatus.SELL,
                stockNumber = 100,
                regTime = LocalDateTime.now(),
                updateTime = LocalDateTime.now(),
            )
        )

        println(item)
    }
}
