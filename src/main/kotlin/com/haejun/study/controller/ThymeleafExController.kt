package com.haejun.study.controller

import com.haejun.study.dto.ItemDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDateTime

@Controller
@RequestMapping(value = ["/thymeleaf"])
class ThymeleafExController {
    @GetMapping(value = ["/ex01"])
    fun thymeleafExample01(model: Model): String {
        model.addAttribute("data", "타임리프 예제 입니다.")
        return "thymeleafEx/thymeleafEx01"
    }

    @GetMapping(value = ["/ex02"])
    fun thymeleafExample02(model: Model): String {
        val itemDto = ItemDto(
            itemDetail = "상품 상세 설명",
            itemNm = "테스트 상품1",
            price = 10000,
            regTime = LocalDateTime.now()
        )

        model.addAttribute("itemDto", itemDto)
        return "thymeleafEx/thymeleafEx02"
    }

    @GetMapping(value = ["/ex03"])
    fun thymeleafExample03(model: Model): String {
        val itemDtoList = (1..10).map {
            ItemDto(
                itemDetail = "상품 상세 설명$it",
                itemNm = "테스트 상품$it",
                price = 1000 * it,
                regTime = LocalDateTime.now()
            )
        }

        model.addAttribute("itemDtoList", itemDtoList)
        return "thymeleafEx/thymeleafEx03"
    }

    @GetMapping(value = ["/ex04"])
    fun thymeleafExample04(model: Model): String {
        val itemDtoList = (1..10).map {
            ItemDto(
                itemDetail = "상품 상세 설명$it",
                itemNm = "테스트 상품$it",
                price = 1000 * it,
                regTime = LocalDateTime.now()
            )
        }

        model.addAttribute("itemDtoList", itemDtoList)
        return "thymeleafEx/thymeleafEx04"
    }

    @GetMapping(value = ["/ex05"])
    fun thymeleafExample05(): String {
        return "thymeleafEx/thymeleafEx05"
    }

    @GetMapping(value = ["/ex06"])
    fun thymeleafExample06(param1: String?, param2: String?, model: Model): String {
        model.addAttribute("param1", param1)
        model.addAttribute("param2", param2)
        return "thymeleafEx/thymeleafEx06"
    }

    @GetMapping(value = ["/ex07"])
    fun thymeleafExample07(): String {
        return "thymeleafEx/thymeleafEx07"
    }
}
