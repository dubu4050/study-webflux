package com.haejun.study.controller

import com.haejun.study.business.MemberService
import com.haejun.study.dto.MemberFormDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/members")
@Controller
class MemberController(
    private val memberService: MemberService,
) {
    @GetMapping("/new")
    fun memberForm(model: Model): String {
        model.addAttribute("memberFormDto", MemberFormDto())
        return "member/memberForm"
    }

    @PostMapping("/new")
    suspend fun memberForm(memberFormDto: MemberFormDto, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            return "member/memberForm"
        }

        memberService.create(memberFormDto)
        return "redirect:/"
    }

    @GetMapping("/login")
    fun loginMember(): String {
        return "member/memberLoginForm"
    }

    @GetMapping("/login/error")
    fun loginError(model: Model): String {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요")
        return "member/memberLoginForm"
    }
}
