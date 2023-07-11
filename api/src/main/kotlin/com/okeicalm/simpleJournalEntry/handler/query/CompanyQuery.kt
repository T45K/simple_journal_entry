package com.okeicalm.simpleJournalEntry.handler.query

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.handler.type.CompanyType
import com.okeicalm.simpleJournalEntry.repository.CompanyRepository
import com.okeicalm.simpleJournalEntry.util.toLong
import org.springframework.stereotype.Component

@Component
class CompanyQuery(private val companyRepository: CompanyRepository) : Query {
    fun allCompanies(): List<CompanyType> = companyRepository.findAll()
        .map(::CompanyType)

    fun company(id: ID): CompanyType? = companyRepository.findById(id.toLong())
        ?.let(::CompanyType)
}
