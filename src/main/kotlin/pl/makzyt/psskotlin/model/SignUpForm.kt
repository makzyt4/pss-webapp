package pl.makzyt.psskotlin.model

import pl.makzyt.psskotlin.validator.PasswordRepeated
import javax.validation.constraints.NotEmpty

@PasswordRepeated(message = "{validation.passwordNotRepeated}")
class SignUpForm {
    @NotEmpty(message = "{validation.emptyData}")
    var companyName: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    var nip: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    var login: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    var password: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    var repeatPassword: String = ""
}