package pl.makzyt.pss_kotlin.model

import javax.persistence.*

@Entity
@Table(name = "app_user")
class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1
    var companyName: String = ""
    var nip: String = ""
    var login: String = ""
    var password: String = ""
    var roles: Array<String> = arrayOf("USER")
}