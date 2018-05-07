package pl.makzyt.psskotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class IndexController {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @PostMapping("/")
    fun indexPost(): String {
        return "loginform"
    }
}