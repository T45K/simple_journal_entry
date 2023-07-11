package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.CompanyType
import com.okeicalm.simpleJournalEntry.usecase.company.CompanyUpdateUseCase
import com.okeicalm.simpleJournalEntry.usecase.company.CompanyUpdateUseCaseInput
import com.okeicalm.simpleJournalEntry.util.toLong
import org.springframework.stereotype.Component

data class UpdateCompanyInput(val id: ID, val name: String)

@Component
class UpdateCompanyMutation(private val companyUpdateUseCase: CompanyUpdateUseCase) : Mutation {
    fun updateCompany(input: UpdateCompanyInput): CompanyType? {
        return companyUpdateUseCase.call(CompanyUpdateUseCaseInput(id = input.id.toLong(), name = input.name))
            ?.let(::CompanyType)
    }
}
