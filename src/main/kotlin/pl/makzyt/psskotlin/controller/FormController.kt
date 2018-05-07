package pl.makzyt.psskotlin.controller

import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import pl.makzyt.psskotlin.model.TravelForm
import pl.makzyt.psskotlin.model.TravelResult
import java.text.SimpleDateFormat
import java.util.*
import javax.validation.Valid

@Controller
@RequestMapping("/travel")
open class GreetingController {

    @InitBinder
    fun bindingPreparation(binder: WebDataBinder) {
        val dateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm")
        val orderDateEditor: CustomDateEditor = CustomDateEditor(dateFormat, true)
        binder.registerCustomEditor(Date::class.java, orderDateEditor)
    }

    @GetMapping("/form")
    fun form(model: Model): String {
        model.addAttribute("form", TravelForm())
        return "travelform"
    }

    @PostMapping("/form")
    fun results(@Valid @ModelAttribute("form") form: TravelForm, result: BindingResult, model: Model): String {
        if (result.hasErrors()) {
            return "travelform"
        }

        model.addAttribute("result", TravelResult(form))

        return "results"
    }
}