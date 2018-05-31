package pl.makzyt.psskotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import pl.makzyt.psskotlin.model.AppUser
import pl.makzyt.psskotlin.model.CreateUserForm
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

    fun create(createUserForm: CreateUserForm) {
        val user = AppUser()

        user.companyName = createUserForm.companyName
        user.login = createUserForm.login
        user.nip = createUserForm.nip
        user.password = BCryptPasswordEncoder().encode(createUserForm.password)
        if (createUserForm.role == "ADMIN") {
            user.roles = arrayOf("ADMIN", "USER")
        }

        appUserRepository.save(user)
    }

    fun findByLogin(login: String): AppUser? {
        return appUserRepository.findByLogin(login)
    }

    fun save(user: AppUser) {
        appUserRepository.save(user)
    }

    fun findAll() {
        appUserRepository.findAll()
    }
}