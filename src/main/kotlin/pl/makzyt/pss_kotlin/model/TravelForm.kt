package pl.makzyt.pss_kotlin.model

import org.springframework.format.annotation.DateTimeFormat
import pl.makzyt.pss_kotlin.validator.CorrectDates
import pl.makzyt.pss_kotlin.validator.PresentOrFuture
import java.util.*
import javax.validation.constraints.NotNull

@CorrectDates(message = "{validation.incorrectDates}")
class TravelForm {

    @NotNull(message = "{validation.emptyData}")
    @PresentOrFuture(message = "{validation.futureDate}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var departureDate: Date? = null

    @NotNull(message = "{validation.emptyData}")
    @PresentOrFuture(message = "{validation.futureDate}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var returnDate: Date? = null
}