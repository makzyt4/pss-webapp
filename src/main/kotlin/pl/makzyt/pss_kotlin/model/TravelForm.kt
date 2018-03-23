package pl.makzyt.pss_kotlin.model

import org.springframework.format.annotation.DateTimeFormat
import pl.makzyt.pss_kotlin.validator.CorrectDates
import pl.makzyt.pss_kotlin.validator.PresentOrFuture
import java.util.*
import javax.validation.constraints.*

@CorrectDates(message = "{validation.incorrectDates}")
class TravelForm {

    @NotNull(message = "{validation.emptyData}")
    @FutureOrPresent(message = "{validation.futureDate}")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    var departureDate: Date? = null

    @NotNull(message = "{validation.emptyData}")
    @FutureOrPresent(message = "{validation.futureDate}")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    var returnDate: Date? = null

    @NotNull(message = "{validation.emptyData}")
    @DecimalMin(value = "0", message = "{validation.negativeCost}")
    var dietCost: Float? = null

    @NotNull(message = "{validation.emptyData}")
    @Pattern(regexp = "^\\d+$", message = "{validation.incorrectNumber}")
    var breakfastNumber: String? = null

    @NotNull(message = "{validation.emptyData}")
    @Pattern(regexp = "^\\d+$", message = "{validation.incorrectNumber}")
    var dinnerNumber: String? = null

    @NotNull(message = "{validation.emptyData}")
    @Pattern(regexp = "^\\d+$", message = "{validation.incorrectNumber}")
    var supperNumber: String? = null

    var transportType: String? = null

    @NotNull(message = "{validation.emptyData}")
    @DecimalMin(value = "0", message = "{validation.negativeCost}")
    var ticketPrice: Float? = null
}