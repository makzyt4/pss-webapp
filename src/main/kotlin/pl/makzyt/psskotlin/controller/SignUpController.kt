package pl.makzyt.psskotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import pl.makzyt.psskotlin.model.SignUpForm
import javax.validation.Valid

@Controller
open class SignUpController {

    @GetMapping("/signup")
    fun form(model: Model): String {
        model.addAttribute("form", SignUpForm())
        return "signupform"
    }

    @PostMapping("/signup")
    fun form(@Valid @ModelAttribute("form") form: SignUpForm, result: BindingResult, model: Model): String {
        if (!result.hasErrors()) {
            model.addAttribute("success", true)
        }

        return "signupform"
    }
}