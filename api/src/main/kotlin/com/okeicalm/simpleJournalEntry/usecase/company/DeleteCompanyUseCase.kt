package com.okeicalm.simpleJournalEntry.usecase.company

import com.okeicalm.simpleJournalEntry.entity.Company
import com.okeicalm.simpleJournalEntry.repository.CompanyRepository
import org.springframework.stereotype.Service

@Service
class DeleteCompanyUseCase(private val companyRepository: CompanyRepository) {
    fun call(id: Long): Company? {
        val company = companyRepository.findById(id) ?: return null
        companyRepository.delete(id)
        return company
    }
}
