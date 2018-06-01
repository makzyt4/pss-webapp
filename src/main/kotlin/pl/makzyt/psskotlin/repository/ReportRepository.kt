package pl.makzyt.psskotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.makzyt.psskotlin.model.Report

@Repository
interface ReportRepository : JpaRepository<Report, Long> {
    fun findAllByOrderByCompanyName(): Array<Report>
    fun findAllByOrderByCreationDate(): Array<Report>
}