package pl.makzyt.psskotlin.model

class Report(form: TravelForm) {
    var depDate: String = ""
    var retDate: String = ""
    var travelTime: String = ""
    var dietCostStr: String = ""
    var breakfastNumber: String = ""
    var dinnerNumber: String = ""
    var supperNumber: String = ""
    var eliminatedCateringCostStr: String = ""
    var transportType: String = ""
    var ticketPriceStr: String = ""
    var travelCostCarBelow900Str: String = ""
    var travelCostCarOver900Str: String = ""
    var travelCostMotorcycleStr: String = ""
    var travelCostMotorbikeStr: String = ""
    var costSumStr: String = ""
    var advanceStr: String = ""
    var costPlusAdvanceStr: String = ""
}