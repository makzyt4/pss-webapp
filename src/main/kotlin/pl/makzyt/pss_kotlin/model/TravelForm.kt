package pl.makzyt.pss_kotlin.model

import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.validation.constraints.NotNull

class TravelForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Proszę podać datę wyjazdu.")
    var departureDate: Date? = null
}