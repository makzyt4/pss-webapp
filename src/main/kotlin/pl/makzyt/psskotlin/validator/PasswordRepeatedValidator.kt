package pl.makzyt.psskotlin.validator

import pl.makzyt.psskotlin.model.SignUpForm
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PasswordRepeatedValidator : ConstraintValidator<PasswordRepeated, SignUpForm> {
    override fun isValid(value: SignUpForm?, context: ConstraintValidatorContext?): Boolean {
        return value?.password == value?.repeatPassword
    }
}