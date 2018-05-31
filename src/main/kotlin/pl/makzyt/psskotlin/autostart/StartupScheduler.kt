package pl.makzyt.psskotlin.autostart

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import pl.makzyt.psskotlin.model.AppUser
import pl.makzyt.psskotlin.service.AppUserService

@Component
class StartupScheduler {
    @Autowired
    lateinit var appUserService: AppUserService

    @EventListener(ContextRefreshedEvent::class)
    fun startup() {
        val user = appUserService.findByLogin("admin")

        if (user == null) {
            val user2 = AppUser()
            user2.password = BCryptPasswordEncoder().encode("admin")
            user2.nip = "0000000000"
            user2.login = "admin"
            user2.companyName = "ADMIN"
            user2.roles = arrayOf("USER", "ADMIN")

            appUserService.save(user2)
        }
    }
}