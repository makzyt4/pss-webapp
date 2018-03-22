package pl.makzyt.pss_kotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
open class GreetingController {

    @GetMapping("/travel/results")
    fun results(): String {
        return "results"
    }

    @GetMapping("/travel/form")
    fun form(): String {
        return "travelform"
    }
}