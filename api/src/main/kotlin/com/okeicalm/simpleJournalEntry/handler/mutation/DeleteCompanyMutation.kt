package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.CompanyType
import com.okeicalm.simpleJournalEntry.usecase.company.DeleteCompanyUseCase
import com.okeicalm.simpleJournalEntry.util.toLong
import org.springframework.stereotype.Component

data class DeleteCompanyInput(val id: ID)

@Component
class DeleteCompanyMutation(private val deleteCompanyUseCase: DeleteCompanyUseCase) : Mutation {
    fun deleteCompany(input: DeleteCompanyInput): CompanyType? {
        return deleteCompanyUseCase.call(input.id.toLong())?.let(::CompanyType)
    }
}
