package pl.makzyt.pss_kotlin.model

import java.math.BigDecimal
import java.sql.Date
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

class TravelForm {
    @NotNull(message = "Proszę podać datę wyjazdu.")
    var departureDate: Date? = null

    @NotNull(message = "Proszę podać datę powrotu.")
    var returnDate: Date? = null

    @NotNull(message = "Proszę podać wysokość diety.")
    @DecimalMin("0.01", inclusive = true, message = "Wysokość diety musi wynosić co najmniej 0.01 zł.")
    var dietCost: BigDecimal? = null

    @NotNull(message = "Proszę podać liczbę śniadań.")
    @Min(0, message = "Minimum to 0.")
    var breakfastNumber: Int = 0

    @NotNull(message = "Proszę podać liczbę obiadów.")
    @Min(0, message = "Minimum to 0.")
    var dinnerNumber: Int = 0

    @NotNull(message = "Proszę podać liczbę kolacji.")
    @Min(0, message = "Minimum to 0.")
    var supperNumber: Int = 0

    var transportType: String = ""

    @NotNull(message = "Proszę podać cenę biletu.")
    @DecimalMin("0", inclusive = true, message = "Cena biletu wynosić co najmniej 0 zł.")
    var ticketCost: BigDecimal? = null

    @NotNull(message = "Proszę podać dane.")
    @DecimalMin("0", inclusive = true, message = "Przejazd musi wynosić co najmniej 0 km.")
    var roadTraveledBelow900: BigDecimal? = null

    @NotNull(message = "Proszę podać dane.")
    @DecimalMin("0", inclusive = true, message = "Przejazd musi wynosić co najmniej 0 km.")
    var roadTraveledOver900: BigDecimal? = null

    @NotNull(message = "Proszę podać dane.")
    @DecimalMin("0", inclusive = true, message = "Przejazd musi wynosić co najmniej 0 km.")
    var roadTraveledOnMotorcycle: BigDecimal? = null

    @NotNull(message = "Proszę podać dane.")
    @DecimalMin("0", inclusive = true, message = "Przejazd musi wynosić co najmniej 0 km.")
    var roadTraveledOnBike: BigDecimal? = null

    @NotNull(message = "Proszę podać dane.")
    @DecimalMin("0", inclusive = true, message = "Zaliczka musi wynosić co najmniej 0 km.")
    var advancePayment: BigDecimal? = null
}