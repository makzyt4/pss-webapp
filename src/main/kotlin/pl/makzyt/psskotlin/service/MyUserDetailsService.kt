package pl.makzyt.psskotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import pl.makzyt.psskotlin.repository.AppUserRepository

@Service
@Transactional
open class MyUserDetailsService : UserDetailsService {
    @Autowired
    lateinit var appUserRepository: AppUserRepository

    override fun loadUserByUsername(login: String): UserDetails {
        val user = appUserRepository.findByLogin(login.toLowerCase())

        val builder = User.withUsername(login)
        builder.password(user.password)
        builder.roles(*user.roles)
        return builder.build()
    }
}