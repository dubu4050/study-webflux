package com.haejun.study.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/")
@Controller
class MainController {

    @GetMapping
    fun main(): String {
        return "main"
    }
}
