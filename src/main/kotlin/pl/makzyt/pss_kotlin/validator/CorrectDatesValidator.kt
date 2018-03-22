package pl.makzyt.pss_kotlin.validator

import pl.makzyt.pss_kotlin.model.TravelForm
import java.util.*
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class CorrectDatesValidator : ConstraintValidator<CorrectDates, TravelForm> {
    override fun isValid(value: TravelForm?, context: ConstraintValidatorContext?): Boolean {
        return value?.departureDate?.before(value.returnDate) ?: false
    }
}