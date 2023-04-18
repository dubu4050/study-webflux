package com.haejun.study.controller

import com.haejun.study.business.ItemService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ItemController(
    private val itemService: ItemService,
) {
    @GetMapping("/admin/item/new")
    fun itemForm(): String? {
        return "item/itemForm"
    }
}
