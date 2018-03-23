package pl.makzyt.pss_kotlin.model

import java.text.SimpleDateFormat

class TravelResult(form: TravelForm) {
    val depDate = SimpleDateFormat("dd.MM.yyyy").format(form.departureDate) + ", godz." + SimpleDateFormat("HH:mm").format(form.departureDate)
    val retDate = SimpleDateFormat("dd.MM.yyyy").format(form.returnDate) + ", godz." + SimpleDateFormat("HH:mm").format(form.returnDate)
    val travelTimeInSec = (form.returnDate!!.time - form.departureDate!!.time) / 1000f
    val travelTimeAllMinutes: Int = (travelTimeInSec / 60).toInt()
    val travelTimeHours: Int = (travelTimeInSec / 3600).toInt()
    val travelTimeMinutes: Int = travelTimeAllMinutes - travelTimeHours * 60
    val travelTime = String.format("%d g %d min", travelTimeHours, travelTimeMinutes)

    val timeCost = (180f / 7f / 24f / 3600f) * (form.returnDate!!.time - form.departureDate!!.time) / 1000f

    val cost = String.format("%.2f zł", timeCost)
}