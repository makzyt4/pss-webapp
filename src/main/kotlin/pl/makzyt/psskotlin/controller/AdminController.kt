package pl.makzyt.psskotlin.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import pl.makzyt.psskotlin.model.CreateUserForm
import pl.makzyt.psskotlin.service.AppUserService
import javax.validation.Valid

@Controller
@RequestMapping("/admin")
class AdminController {
    @Autowired
    lateinit var appUserService: AppUserService

    @GetMapping("/createuser")
    fun createUser(model: Model): String {
        model.addAttribute("form", CreateUserForm())
        return "createuser"
    }

    @PostMapping("/createuser")
    fun form(@Valid @ModelAttribute("form") form: CreateUserForm, result: BindingResult, model: Model): String {
        if (!result.hasErrors()) {
            model.addAttribute("success", true)
            appUserService.create(form)
        }

        return "signupform"
    }
}