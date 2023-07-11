package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.CompanyType
import org.springframework.stereotype.Component

data class DeleteCompanyInput(val id: ID)

@Component
class DeleteCompanyMutation : Mutation {
    fun deleteCompany(input: DeleteCompanyInput): CompanyType = TODO()
}
