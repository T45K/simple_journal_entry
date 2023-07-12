package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.CompanyType
import com.okeicalm.simpleJournalEntry.usecase.company.CompanyCreateUseCase
import org.springframework.stereotype.Component

data class CreateCompanyInput(val name: String)

@Component
class CreateCompanyMutation(private val companyCreateUseCase: CompanyCreateUseCase) : Mutation {
    fun createCompany(input: CreateCompanyInput): CompanyType {
        val company = companyCreateUseCase.call(input.name)
        return CompanyType(company)
    }
}
