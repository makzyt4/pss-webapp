package pl.makzyt.psskotlin.model

import org.hibernate.validator.constraints.Length
import pl.makzyt.psskotlin.validator.UniqueLogin
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

class CreateUserForm {
    @NotEmpty(message = "{validation.emptyData}")
    var companyName: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    @Pattern(message = "{validation.incorrectNIP}", regexp = "\\d{10}")
    var nip: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    @UniqueLogin(message = "{validation.loginNotUnique}")
    @Pattern(message = "{validation.loginRegex}", regexp = "[\\w\\d]{5,16}")
    var login: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    @Length(min = 6, max = 32, message = "{validation.passwordLength}")
    var password: String = ""
    @NotEmpty(message = "{validation.emptyData}")
    var role: String = ""
}