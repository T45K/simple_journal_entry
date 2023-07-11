package com.okeicalm.simpleJournalEntry.usecase.company

import com.okeicalm.simpleJournalEntry.entity.Company
import com.okeicalm.simpleJournalEntry.repository.CompanyRepository
import org.springframework.stereotype.Service


@Service
class CompanyCreateUseCase(private val companyRepository: CompanyRepository) {
    fun call(name: String): Company {
        return companyRepository.create(Company(name = name))
    }
}
