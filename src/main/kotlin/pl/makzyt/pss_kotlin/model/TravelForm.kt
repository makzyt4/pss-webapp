package pl.makzyt.pss_kotlin.model

import org.springframework.format.annotation.DateTimeFormat
import pl.makzyt.pss_kotlin.validator.PresentOrFuture
import java.util.*
import javax.validation.constraints.NotNull

class TravelForm {

    @PresentOrFuture(message = "Data musi być określona od dziś włącznie.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Proszę podać dane.")
    var departureDate: Date? = null

    @PresentOrFuture(message = "Data musi być określona od dziś włącznie.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Proszę podać dane.")
    var returnDate: Date? = null
}