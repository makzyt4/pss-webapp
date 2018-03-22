package pl.makzyt.pss_kotlin.validator

import java.util.*
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PresentOrFutureValidator : ConstraintValidator<PresentOrFuture, Date> {

    override fun isValid(value: Date?, context: ConstraintValidatorContext?): Boolean {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)

        val today = calendar.time

        return if (value != null) !value.before(today) || value.after(today) else false
    }
}