package com.haejun.study.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OperationController {
    @GetMapping
    fun getStatus() {
        return
    }
}
