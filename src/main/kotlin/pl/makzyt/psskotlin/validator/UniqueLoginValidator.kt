package pl.makzyt.psskotlin.validator

import org.springframework.beans.factory.annotation.Autowired
import pl.makzyt.psskotlin.service.AppUserService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UniqueLoginValidator : ConstraintValidator<UniqueLogin, String> {
    @Autowired
    lateinit var appUserService: AppUserService

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return appUserService.findByLogin(value!!) == null
    }
}