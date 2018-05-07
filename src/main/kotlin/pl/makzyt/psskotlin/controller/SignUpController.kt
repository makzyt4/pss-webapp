package pl.makzyt.psskotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import pl.makzyt.psskotlin.model.SignUpForm
import pl.makzyt.psskotlin.model.TravelForm
import javax.validation.Valid

@Controller
@RequestMapping("/travel")
open class SignUpController {

    @GetMapping("/signup")
    fun form(model: Model): String {
        model.addAttribute("form", SignUpForm())
        return "signupform"
    }

    @PostMapping("/form")
    fun results(@Valid @ModelAttribute("form") form: SignUpForm, result: BindingResult, model: Model): String {
        if (result.hasErrors()) {
            return "signupform"
        }

        return "redirect:/login"
    }
}