package com.okeicalm.simpleJournalEntry.usecase.company

import com.okeicalm.simpleJournalEntry.entity.Company
import com.okeicalm.simpleJournalEntry.repository.CompanyRepository
import org.springframework.stereotype.Component

data class CompanyUpdateUseCaseInput(val id: Long, val name: String)

@Component
class CompanyUpdateUseCase(private val companyRepository: CompanyRepository) {
    fun call(input: CompanyUpdateUseCaseInput): Company? {
        val company = Company(id = input.id, name = input.name)
        return companyRepository.update(company)
    }
}
