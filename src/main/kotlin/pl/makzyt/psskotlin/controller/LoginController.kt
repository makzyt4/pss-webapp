package pl.makzyt.psskotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import pl.makzyt.psskotlin.model.LoginForm
import java.security.Principal

@Controller
class LoginController {
    @GetMapping("/login")
    fun login(model: Model, principal: Principal?): String {
        if (principal != null) {
            return "redirect:/"
        }

        model.addAttribute("form", LoginForm())
        return "loginform"
    }

    @PostMapping("/login")
    fun loginFailure(model: Model): String {
        model.addAttribute("form", LoginForm())
        model.addAttribute("failure", true)
        return "loginform"
    }

    @PostMapping("/logout")
    fun logout(): String {
        return "logout"
    }
}