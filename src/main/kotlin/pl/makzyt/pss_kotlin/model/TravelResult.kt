package pl.makzyt.pss_kotlin.model

import java.text.SimpleDateFormat

class TravelResult(form: TravelForm) {
    val depDate = SimpleDateFormat("dd.MM.yyyy").format(form.departureDate)
}