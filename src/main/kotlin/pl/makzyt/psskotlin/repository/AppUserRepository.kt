package pl.makzyt.psskotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.makzyt.psskotlin.model.AppUser

@Repository
interface AppUserRepository : JpaRepository<AppUser, Long> {
    fun findByLogin(login: String): AppUser?
}