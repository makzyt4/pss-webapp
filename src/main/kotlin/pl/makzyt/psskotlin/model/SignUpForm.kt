package pl.makzyt.psskotlin.model

import javax.validation.constraints.NotEmpty

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