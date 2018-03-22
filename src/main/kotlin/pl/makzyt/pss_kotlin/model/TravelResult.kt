package pl.makzyt.pss_kotlin.model

import java.text.SimpleDateFormat

class TravelResult(form: TravelForm) {
    val depDate = SimpleDateFormat("dd.MM.yyyy HH:mm").format(form.departureDate)
    val retDate = SimpleDateFormat("dd.MM.yyyy HH:mm").format(form.returnDate)
}