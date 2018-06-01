package pl.makzyt.psskotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pl.makzyt.psskotlin.model.Report
import pl.makzyt.psskotlin.model.TravelResult
import pl.makzyt.psskotlin.repository.ReportRepository
import java.security.Principal

@Service
class ReportService {
    @Autowired
    lateinit var reportRepository: ReportRepository

    @Autowired
    lateinit var appUserService: AppUserService

    fun findAll(): MutableList<Report>? {
        return reportRepository.findAll()
    }

    fun saveFromResult(principal: Principal?, travelResult: TravelResult) {
        val user = appUserService.findByLogin(principal!!.name) ?: return

        val report = Report()
        report.author = user

        report.depDate = travelResult.depDate
        report.retDate = travelResult.retDate
        report.travelTime = travelResult.travelTime
        report.dietCostStr = travelResult.dietCostStr
        report.breakfastNumber = travelResult.breakfastNumber.toString()
        report.dinnerNumber = travelResult.dinnerNumber.toString()
        report.supperNumber = travelResult.supperNumber.toString()
        report.eliminatedCateringCostStr = travelResult.eliminatedCateringCostStr
        report.transportType = travelResult.transportType
        report.ticketPriceStr = travelResult.ticketPriceStr
        report.travelCostCarBelow900Str = travelResult.travelCostCarBelow900Str
        report.travelCostCarOver900Str = travelResult.travelCostCarOver900Str
        report.travelCostMotorcycleStr = travelResult.travelCostMotorcycleStr
        report.travelCostMotorbikeStr = travelResult.travelCostMotorbikeStr
        report.costSumStr = travelResult.costSumStr
        report.advanceStr = travelResult.advanceStr
        report.costPlusAdvanceStr = travelResult.costPlusAdvanceStr

        reportRepository.save(report)
    }
}