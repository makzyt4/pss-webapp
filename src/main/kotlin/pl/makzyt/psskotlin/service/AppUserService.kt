package pl.makzyt.psskotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import pl.makzyt.psskotlin.model.AppUser
import pl.makzyt.psskotlin.model.SignUpForm
import pl.makzyt.psskotlin.repository.AppUserRepository

@Service
class AppUserService {
    @Autowired
    lateinit var appUserRepository: AppUserRepository

    fun register(signUpForm: SignUpForm) {
        val user = AppUser()
        user.companyName = signUpForm.companyName
        user.login = signUpForm.login
        user.nip = signUpForm.nip
        user.password = BCryptPasswordEncoder().encode(signUpForm.password)

        appUserRepository.save(user)
    }
}