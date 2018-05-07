package pl.makzyt.psskotlin.validator

import pl.makzyt.psskotlin.model.TravelForm
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class CorrectDatesValidator : ConstraintValidator<CorrectDates, TravelForm> {
    override fun isValid(value: TravelForm?, context: ConstraintValidatorContext?): Boolean {
        if (value?.departureDate == null || value.returnDate == null) {
            return false
        }

        return value.departureDate?.before(value.returnDate) ?: false
    }
}