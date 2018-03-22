package pl.makzyt.pss_kotlin.model

import org.springframework.format.annotation.DateTimeFormat
import pl.makzyt.pss_kotlin.validator.PresentOrFuture
import java.util.*
import javax.validation.constraints.NotNull

class TravelForm {

    @NotNull(message = "{validation.enterData}")
    @PresentOrFuture(message = "{validation.futureDate}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var departureDate: Date? = null

    @NotNull(message = "{validation.enterData}")
    @PresentOrFuture(message = "{validation.futureDate}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var returnDate: Date? = null
}