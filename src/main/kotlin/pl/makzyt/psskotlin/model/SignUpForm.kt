package pl.makzyt.psskotlin.model

import org.hibernate.validator.constraints.Length
import pl.makzyt.psskotlin.validator.PasswordRepeated
import pl.makzyt.psskotlin.validator.UniqueLogin
import javax.validation.constraints.NotEmpty

@PasswordRepeated(message = "{validation.passwordNotRepeated}")
class SignUpForm {
    @NotEmpty(message = "{validation.emptyData}")
    var companyName: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    var nip: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    @UniqueLogin(message = "{validation.loginNotUnique}")
    var login: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    @Length(min = 6, max = 32, message = "{validation.passwordLength}")
    var password: String = ""
    var repeatPassword: String = ""
}