package pl.makzyt.pss_kotlin.model

import java.text.SimpleDateFormat

class TravelResult(form: TravelForm) {
    val depDate: String = SimpleDateFormat("dd.MM.yyyy").format(form.departureDate) +
            ", godz." + SimpleDateFormat("HH:mm").format(form.departureDate)
    val retDate: String = SimpleDateFormat("dd.MM.yyyy").format(form.returnDate) +
            ", godz." + SimpleDateFormat("HH:mm").format(form.returnDate)
    val travelTimeInSec: Float = (form.returnDate!!.time - form.departureDate!!.time) / 1000f
    val travelTimeAllMinutes: Int = (travelTimeInSec / 60).toInt()
    val travelTimeHours: Int = (travelTimeInSec / 3600).toInt()
    val travelTimeMinutes: Int = travelTimeAllMinutes - travelTimeHours * 60
    val travelTime: String = String.format("%d g %d min", travelTimeHours, travelTimeMinutes)
    val dietCostStr: String = String.format("%.2f zł", form.dietCost)
    val breakfastNumber: Int = Integer.parseInt(form.breakfastNumber)
    val dinnerNumber: Int = Integer.parseInt(form.dinnerNumber)
    val supperNumber: Int = Integer.parseInt(form.supperNumber)
    val transportType: String? = form.transportType
    val eliminatedCateringCostStr: String = String.format("%.2f zł",
            7.5f * breakfastNumber + 15f * dinnerNumber + 7.5f * supperNumber)
    val ticketPriceStr: String = String.format("%.2f zł", form.ticketPrice)
    val advanceStr = String.format("%.2f zł", form.advance)

    val timeCost = (180f / 7f / 24f / 3600f) * (form.returnDate!!.time - form.departureDate!!.time) / 1000f
    val ticketPrice: Float = form.ticketPrice!!
    val travelCostCarBelow900 = 0.52 * form.trackCarBelow900!!
    val travelCostCarOver900 = 0.84 * form.trackCarOver900!!
    val travelCostMotorcycle = 0.23 * form.trackMotorcycle!!
    val travelCostMotorbike = 0.14 * form.trackMotorbike!!
    val advance = form.advance!!

    val travelCostCarBelow900Str = String.format("%.2f zł", 0.52 * form.trackCarBelow900!!)
    val travelCostCarOver900Str = String.format("%.2f zł", 0.84 * form.trackCarOver900!!)
    val travelCostMotorcycleStr = String.format("%.2f zł", 0.23 * form.trackMotorcycle!!)
    val travelCostMotorbikeStr = String.format("%.2f zł", 0.14 * form.trackMotorbike!!)

    val costSum = timeCost +
            ticketPrice +
            travelCostCarBelow900 +
            travelCostCarOver900 +
            travelCostMotorcycle +
            travelCostMotorbike

    val costSumStr = String.format("%.2f zł", costSum)
    val costPlusAdvanceStr = String.format("%.2f zł", costSum + advance)
}