package pl.makzyt.psskotlin.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import pl.makzyt.psskotlin.model.CreateUserForm
import pl.makzyt.psskotlin.service.AppUserService
import pl.makzyt.psskotlin.service.ReportService
import javax.validation.Valid

@Controller
@RequestMapping("/admin")
class AdminController {
    @Autowired
    lateinit var appUserService: AppUserService

    @Autowired
    lateinit var reportService: ReportService

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

    @GetMapping("/reports")
    fun reports(model: Model): String {
        model.addAttribute("reportList", reportService.findAll())

        return "reportlist"
    }

    @GetMapping("/reports/show/{id}")
    fun reportsShow(@PathVariable("id") id: Long, model: Model): String {
        val report = reportService.findById(id)!!.get()
        model.addAttribute("result", report)

        return "results"
    }

    @GetMapping("/reports/delete/{id}")
    fun reportsDelete(@PathVariable("id") id: Long, model: Model): String {
        reportService.deleteById(id)
        model.addAttribute("reportList", reportService.findAll())

        return "redirect:/admin/reports"
    }
}